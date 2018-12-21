package com.m813.repositories;

import com.m813.datamodel.equipment.*;
import com.m813.datamodel.membership.*;
import com.m813.datamodel.training.*;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class EquipmentBookingRepository extends RepositoryBase<EquipmentBooking>
{
    public Boolean changeBookingEndDate(EquipmentBooking booking, Date newEndDate)
    {
        Predicate<EquipmentBooking> filter = bking -> bking.Id.equals(booking.Id);

        try
        {
            EquipmentBooking selectedBooking = getSingle(filter);
            selectedBooking.setEndDate(newEndDate);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    /*
    * Returns all bookings which are active between date1 and date2 inclusively
    */
    public EquipmentBooking[] getEquipmentBookedBetween(Date date1, Date date2)
    {
        Predicate<EquipmentBooking> bookedBetween = booking ->
        {
            Date startDate = booking.getStartDate();
            Date endDate = booking.getEndDate();

            Predicate<Date> inRange = date -> (date.equals(date1) || date.after(date1))
                                           && (date.equals(date2) || date.before(date2));

            return inRange.test(startDate) || inRange.test(endDate);
        };

        return filterEntities(bookedBetween).toArray(new EquipmentBooking[0]);
    }

    /*
    *  Overload of getEquipmentBookedBetween that narrows filter down by equipment
    */
    public EquipmentBooking[] getEquipmentBookedBetween(Equipment equipment, Date date1, Date date2)
    {
        EquipmentBooking[] allBookingsBetween = getEquipmentBookedBetween(date1, date2);

        LinkedList<EquipmentBooking> bookingsBetweenForEquipment = new LinkedList<>();

        for(EquipmentBooking booking : allBookingsBetween)
        {
            if (booking.getEquipment().Id.equals(equipment.Id))
            {
                bookingsBetweenForEquipment.add(booking);
            }
        }

        return bookingsBetweenForEquipment.toArray(new EquipmentBooking[0]);
    }


    /*
    * @Identifier = SO2
    * @Invariant = true
    * @Precondition:
    *     --startDate is before endDate
    *     --The difference between startDate and endDate is not greater than 14 days
    *     --member, equipment, startDate, endDate and errors are not null
    *     --course is optional
    *     --no other EquipmentBooking for equipment exists between startDate and endDate
    * @Postcondition:
    *     --return an object of EquipmentBooking
    *     --whose attributes are initialized
    *     --which is linked to the correct Equipment, Member and Course
    *     --or return null
    *     --with error messages in error dictionary
    */
    public EquipmentBooking createEquipmentBooking(Member member, Course course, Equipment equipment,
        Date startDate, Date endDate, HashMap<String, String> errors)
    {
        //should be passed an empty HashMap for errors, but...
        HashMap<String, String> localErrors = new HashMap<>();
        String methodKey = "EquipmentBooking_CreateBooking"; //Key specific to this method

        if(member == null || !member.isCurrentMember())
        {
            localErrors.put(methodKey, "Cannot issue a booking to this member");
        }

        if(startDate == null || endDate == null)
        {
            localErrors.put(methodKey, "Please provide suitable dates for the booking");
        }
        else
        {
            if(endDate.before(startDate))
            {
                localErrors.put(methodKey, "Cannot issue a booking that ends before it begins");
            }

            long dateDifference = endDate.getTime() - startDate.getTime();
            long daysDifference = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
            if(daysDifference > 14)
            {
                localErrors.put(methodKey, "Booking cannot be greater than two weeks");
            }

            if(equipment == null)
            {
                localErrors.put(methodKey, "Cannot issue a booking for this equipment");
            }
            else
            {
                EquipmentBooking[] existingBookings = getEquipmentBookedBetween(equipment, startDate, endDate);
                if(existingBookings.length > 0)
                {
                    localErrors.put(methodKey, "This piece of equipment is already booked");
                }
            }
        }

        if(localErrors.size() == 0)
        {
            EquipmentBooking newBooking = new EquipmentBooking(member, course, equipment, startDate, endDate);
            this._allEntities.add(newBooking);
            return newBooking;
        }
        else
        {
            errors.putAll(localErrors);
            return null;
        }
    }
}

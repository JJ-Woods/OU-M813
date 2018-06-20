package com.m813.repositories;

import com.m813.equipment.*;
import com.m813.membership.*;
import com.m813.training.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

public class EquipmentRepository
{
    private List<Equipment> allEquipment;

    private List<EquipmentBooking> allBookings;

    public Equipment[] getAllEquipment()
    {
        throw new NotImplementedException();
    }

    public Equipment[] getEquipmentByName(String name)
    {
        throw new NotImplementedException();
    }

    public Equipment[] getEquipmentByBrand(EquipmentBrand brand)
    {
        throw new NotImplementedException();
    }

    public Equipment[] getEquipmentByDatePurchased(Date date)
    {
        throw new NotImplementedException();
    }

    public Equipment[] getEquipmentPurchasedBetween(Date from, Date to)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentName(Equipment equ, String name)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentBrand(Equipment equ, EquipmentBrand brand)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentDate(Equipment equ, Date date)
    {
        throw new NotImplementedException();
    }

    public Equipment createEquipment(String name, EquipmentBrand brand, Date date)
    {
        throw new NotImplementedException();
    }

    public Equipment createEquipment(String name, EquipmentBrand brand)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getAllEquipmentBookings()
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getEquipmentBookingByMember(Member mem)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getEquipmentBookingByCourse(Course course)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getEquipmentBookingByEquipment(Equipment equipment)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getEquipmentBookingBookedOn(Date bookedOn)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking[] getEquipmentBookedBetween(Date to, Date from)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentBookingMember(EquipmentBooking eBooking, Member mem)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentBookingCourse(EquipmentBooking eBooking, Course course)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentBookingEquipment(EquipmentBooking eBooking, Equipment equipment)
    {
        throw new NotImplementedException();
    }

    public Boolean updateEquipmentBookingDate(EquipmentBooking eBooking, Date date)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking createEquipmentBooking(Member mem, Course course, Equipment equipment, Date date)
    {
        throw new NotImplementedException();
    }

    public EquipmentBooking createEquipmentBooking(Member mem, Course course, Equipment equipment)
    {
        return createEquipmentBooking(mem, course, equipment, null);
    }

    public EquipmentBooking createEquipmentBooking(Member mem, Equipment equipment, Date date)
    {
        return createEquipmentBooking(mem, null, equipment, date);
    }

    public EquipmentBooking createEquipmentBooking(Member mem, Equipment equipment)
    {
        return createEquipmentBooking(mem, null, equipment, null);
    }
}

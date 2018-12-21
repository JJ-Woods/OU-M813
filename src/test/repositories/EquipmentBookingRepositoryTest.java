package test.repositories;

import com.m813.datamodel.equipment.*;
import com.m813.datamodel.membership.*;
import com.m813.repositories.EquipmentBookingRepository;

import static junit.framework.TestCase.*;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class EquipmentBookingRepositoryTest
{
    private static EquipmentBookingRepository _repo;

    private static Date exampleStartDate;
    private static Date exampleEndDateBeforeStart;
    private static Date exampleEndDateOneWeekAfterStart;
    private static Date exampleEndDateThreeWeeksAfterStart;

    private static Member exampleCurrentMember;
    private static Member exampleExpiredMember;

    private static Equipment exampleEquipment;

    @Before
    public void setup() throws ParseException
    {
        _repo = new EquipmentBookingRepository();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        exampleStartDate =  dateFormat.parse("01/08/2018");
        exampleEndDateBeforeStart = dateFormat.parse("01/07/2018");
        exampleEndDateOneWeekAfterStart = dateFormat.parse("08/08/2018");
        exampleEndDateThreeWeeksAfterStart = dateFormat.parse("22/08/2018");

        MemberCategory memberCategory = new MemberCategory("Basic Member", 6, 100);
        exampleCurrentMember = new Member("MEM001", "John Doe", "j.doe@gmail.com",
                MemberRole.MEMBER, memberCategory, dateFormat.parse("01/08/2018"));
        exampleExpiredMember = new Member("MEM002", "Jane Doe", "j.doe@gmail.com",
                MemberRole.MEMBER, memberCategory, dateFormat.parse("01/08/2000"));

        exampleEquipment = new OtherEquipment("EQU001", "Commando BCD", EquipmentBrand.APEKS, new Date());
    }

    @Test
    public void getEquipmentBookedBetween_WithEmptyRepository_ShouldReturnNone()
    {
        EquipmentBooking[] bookingsBetween =
                _repo.getEquipmentBookedBetween(exampleStartDate, exampleEndDateOneWeekAfterStart);
        int numBookings = bookingsBetween.length;

        assertEquals(0, numBookings);
    }

    @Test
    public void getEquipmentBookedBetween_AfterAddingThreeDifferentEquipment_ShouldReturnThree()
    {
        Equipment equipment1 = new OtherEquipment("EQU001", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment1,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        Equipment equipment2 = new OtherEquipment("EQU002", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment2,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        Equipment equipment3 = new OtherEquipment("EQU003", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment3,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        EquipmentBooking[] bookingsBetween =
                _repo.getEquipmentBookedBetween(exampleStartDate, exampleEndDateOneWeekAfterStart);
        int numBookings = bookingsBetween.length;

        assertEquals(3, numBookings);
    }

    @Test
    public void getEquipmentBookedBetween_GivenEquipment_WithEmptyRepository_ShouldReturnNone()
    {
        EquipmentBooking[] bookingsBetween =
                _repo.getEquipmentBookedBetween(exampleEquipment, exampleStartDate, exampleEndDateOneWeekAfterStart);
        int numBookings = bookingsBetween.length;

        assertEquals(0, numBookings);
    }

    @Test
    public void getEquipmentBookedBetween_GivenEquipment_AfterAddingThreeDifferentEquipment_ShouldReturnOne()
    {
        Equipment equipment1 = new OtherEquipment("EQU001", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment1,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        Equipment equipment2 = new OtherEquipment("EQU002", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment2,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        Equipment equipment3 = new OtherEquipment("EQU003", "Commando BCD", EquipmentBrand.APEKS, new Date());
        _repo.createEquipmentBooking(exampleCurrentMember, null, equipment3,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        EquipmentBooking[] bookingsBetween =
                _repo.getEquipmentBookedBetween(equipment1, exampleStartDate, exampleEndDateOneWeekAfterStart);
        int numBookings = bookingsBetween.length;

        assertEquals(1, numBookings);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnBooking_WithNoErrors()
    {
        HashMap<String, String> errors = new HashMap<>();
        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateOneWeekAfterStart, errors);

        int numErrors = errors.size();

        assertEquals(0, numErrors);
        assertNotNull(booking);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyMemberError()
    {
        HashMap<String, String> errors = new HashMap<>();

        EquipmentBooking booking = _repo.createEquipmentBooking(exampleExpiredMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateOneWeekAfterStart, errors);

        int numErrors = errors.size();
        Boolean errorsContainMemberError = errors.containsValue("Cannot issue a booking to this member");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainMemberError);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyDoubleBookingError()
    {
        //Make an initial booking
        _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateOneWeekAfterStart, new HashMap<>());

        HashMap<String, String> errors = new HashMap<>();

        //Try and book for the exact same time
        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateOneWeekAfterStart, errors);

        int numErrors = errors.size();
        Boolean errorsContainEquipmentError = errors.containsValue("This piece of equipment is already booked");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainEquipmentError);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyEquipmentError()
    {
        HashMap<String, String> errors = new HashMap<>();

        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, null,
                exampleStartDate, exampleEndDateOneWeekAfterStart, errors);

        int numErrors = errors.size();
        Boolean errorsContainEquipmentError = errors.containsValue("Cannot issue a booking for this equipment");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainEquipmentError);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyNullDateError()
    {
        HashMap<String, String> errors = new HashMap<>();
        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                null, null, errors);

        int numErrors = errors.size();
        Boolean errorsContainNullDateError = errors.containsValue("Please provide suitable dates for the booking");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainNullDateError);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyStartBeforeEndError()
    {
        HashMap<String, String> errors = new HashMap<>();
        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateBeforeStart, errors);

        int numErrors = errors.size();
        Boolean errorsContainStartBeforeEndError = errors.containsValue("Cannot issue a booking that ends before it begins");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainStartBeforeEndError);
    }

    @Test
    public void createEquipmentBooking_ShouldReturnNull_WithOnlyBookingTooLongError()
    {
        HashMap<String, String> errors = new HashMap<>();
        EquipmentBooking booking = _repo.createEquipmentBooking(exampleCurrentMember, null, exampleEquipment,
                exampleStartDate, exampleEndDateThreeWeeksAfterStart, errors);

        int numErrors = errors.size();
        Boolean errorsContainBookingTooLongError = errors.containsValue("Booking cannot be greater than two weeks");

        assertNull(booking);
        assertEquals(1, numErrors);
        assertTrue(errorsContainBookingTooLongError);
    }
}
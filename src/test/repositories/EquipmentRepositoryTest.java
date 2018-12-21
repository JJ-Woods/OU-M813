package test.repositories;

import com.m813.datamodel.equipment.*;
import com.m813.repositories.EquipmentRepository;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class EquipmentRepositoryTest
{
    private static EquipmentRepository _repo;

    private HashMap<String, String> errors;

    @BeforeClass
    public static void setupClass()
    {
        _repo = new EquipmentRepository();
    }

    @Before
    public void setup()
    {
        errors = new HashMap<>();
    }

    //Delete all data from the repo after each operation as to not interfere with other tests
    @After
    public void tearDown()
    {
        List<Equipment> allEquipment = _repo.getAll();
        _repo.removeSelected(allEquipment);
    }

    @Test
    public void createEquipment_ShouldReturnEquipment_WithNoErrors()
    {
        Equipment equipment = _repo.createEquipment(OtherEquipment.class, "TestEquipment",
                EquipmentBrand.APEKS, new Date(), null, errors);

        int numErrors = errors.size();

        assertNotNull(equipment);
        assertEquals(0, numErrors);
    }

    @Test
    public void createEquipment_ShouldReturnNull_WithOnlyNameError()
    {
        Equipment equipment = _repo.createEquipment(OtherEquipment.class, null,
                EquipmentBrand.APEKS, new Date(), null, errors);

        int numErrors = errors.size();
        Boolean errorsContainNameError = errors.containsValue("Please supply an name for this equipment");

        assertNull(equipment);
        assertEquals(1, numErrors);
        assertTrue(errorsContainNameError);
    }

    @Test
    public void createEquipment_ShouldReturnNull_WithOnlyBrandError()
    {
        Equipment equipment = _repo.createEquipment(OtherEquipment.class, "TestEquipment",
                null, new Date(), null, errors);

        int numErrors = errors.size();
        Boolean errorsContainBrandError = errors.containsValue("Please supply a brand for this equipment");

        assertNull(equipment);
        assertEquals(1, numErrors);
        assertTrue(errorsContainBrandError);
    }

    @Test
    public void createEquipment_ShouldReturnNull_WithOnlyNullPurchasedError()
    {
        Equipment equipment = _repo.createEquipment(OtherEquipment.class, "TestEquipment",
                EquipmentBrand.APEKS, null, null, errors);

        int numErrors = errors.size();
        Boolean errorsContainPurchasedError =
                errors.containsValue("Please specify when this equipment was purchased");

        assertNull(equipment);
        assertEquals(1, numErrors);
        assertTrue(errorsContainPurchasedError);
    }

    @Test
    public void createEquipment_ShouldReturnNull_WithOnlyPurchasedError() throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date y2k =  dateFormat.parse("01/01/2000");

        Equipment equipment = _repo.createEquipment(OtherEquipment.class, "TestEquipment",
                EquipmentBrand.APEKS, y2k, null, errors);

        int numErrors = errors.size();
        Boolean errorsContainPurchasedError =
                errors.containsValue("Please enter a valid date for when this equipment was purchased");

        assertNull(equipment);
        assertEquals(1, numErrors);
        assertTrue(errorsContainPurchasedError);
    }
}
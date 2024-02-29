import code.DateTime;
import code.VehicleType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VehicleTypeTest {

    private static VehicleType car;
    private static VehicleType van;

    @BeforeAll
    public static void setUp() {
        car = new VehicleType(4);
        van = new VehicleType(15, new DateTime(2));
    }

    @Test
    @Order(1)
    public void testGetSeatsForCar() {
        assertEquals(4, car.getSeats("car"));
    }

    @Test
    @Order(2)
    public void testGetSeatsForVan() {
        assertEquals(15, van.getSeats("van"));
    }

    @Test
    @Order(3)
    public void testSetCarSeats() {
        car.setCarSeats(5);
        assertEquals(5, car.getCarSeats());
    }

    @Test
    @Order(4)
    public void testCanRentCarForMinimumDays() {
        DateTime rentDate = new DateTime(2024, 2, 25);
        assertEquals(2, car.canBeRentedForMinimumDays(rentDate, "car"));
    }

    @Test
    @Order(5)
    public void testIsUnderMaintenance() {
        DateTime rentDate = new DateTime(10);
        assertTrue(van.IsUnderMaintenance(rentDate, "van", 10));
    }
}

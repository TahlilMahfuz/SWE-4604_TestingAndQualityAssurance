import code.Car;
import code.DateTime;
import code.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("C_001", 2022, "Toyota", "Camry", 0, new VehicleType(5));
    }

    @Test
    public void testReturnVehicleSuccess() {
        car.rent("Customer1", new DateTime(20, 2, 2025), 3);
        assertTrue(car.returnVehicle(new DateTime(22, 2, 2028)));

    }

    @Test
    public void testReturnVehicleBeforeMinimumDays() {
        car.rent("Customer3", new DateTime(1,3,2022), 3);
        assertTrue(car.returnVehicle(new DateTime(3,3,2022)));
    }
    @Test
    public void testReturnVehicleAfterMaximumDays() {
        car.rent("Customer4", new DateTime(1,3,2022), 13);
        assertTrue(car.returnVehicle(new DateTime(14,3,2022)));
    }
    @Test
    public void TestLateFee(){
        assertEquals(106957.5, car.getLateFee(new DateTime(22, 2, 2028), new DateTime(20, 2, 2025)), 0.01);
    }
}

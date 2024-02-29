import code.DateTime;
import code.Vehicle;
import code.VehicleType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTesting {
    private static Vehicle vehicle;
    private static DateTime rentDate;

    @BeforeAll
    public static void setUp() {
        VehicleType vehicleType = new VehicleType(4);
        vehicle = new Vehicle("C_001", 2022, "Toyota", "Corolla", 0, vehicleType);
        rentDate = new DateTime(2024, 2, 25);
    }

    @Test
    public void testRentVehicleInsufficientRentalDays() {
        boolean rented = vehicle.rent("C_ustomer1", rentDate, 1);
        assertFalse(rented);
    }

    @Test
    public void testPerformMaintenanceSuccessfully() {
        boolean maintenancePerformed = vehicle.performMaintenance();
        assertTrue(maintenancePerformed);
    }
    @Test
    public void testRentVehicleSuccessfully() {
        setUp();
        boolean rented = vehicle.rent("C_ustomer1", rentDate, 3);
        assertTrue(rented);
    }

    @Test
    public void testGetVehicleDetails() {
        String details = vehicle.getDetails();
        assertNotNull(details);
    }

    @Test
    public void testGetVehicleId() {
        String vehicleId = vehicle.getVehicleId();
        assertEquals("C_001", vehicleId);
    }
    @Test
    public void testRentVehicleInvalidRentalDays() {
        boolean rented = vehicle.rent("C_ustomer1", rentDate, 15); // Trying to rent for 15 days (beyond allowed)
        assertFalse(rented);
    }
}

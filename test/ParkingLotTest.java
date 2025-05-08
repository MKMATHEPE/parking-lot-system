import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void testParkVehicle() {
        ParkingLot pl = new ParkingLot("TEST", 2, 5);
        String ticket = pl.parkVehicle("car", "TEST-123", "red");
        assertNotNull(ticket);
        assertEquals(4, pl.getNoOfOpenSlots("car"));
    }
    
    @Test
    public void testUnparkVehicle() {
        ParkingLot pl = new ParkingLot("TEST", 2, 5);
        String ticket = pl.parkVehicle("bike", "TEST-456", "blue");
        pl.unPark(ticket);
        assertEquals(2, pl.getNoOfOpenSlots("bike"));
    }
}

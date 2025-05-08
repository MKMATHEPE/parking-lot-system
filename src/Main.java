public class Main {
    public static void main(String[] args) {
        System.out.println("=== Parking Lot System Testing ===");
        System.out.println("Creating parking lot with 3 floors and 6 slots per floor...");
        
        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot("PR123", 3, 6);
        System.out.println("Parking lot created successfully!\n");

        // Test 1: Check initial available slots
        System.out.println("--- Test 1: Initial Slot Availability ---");
        System.out.println("Available car slots: " + parkingLot.getNoOfOpenSlots("car"));
        System.out.println("Available bike slots: " + parkingLot.getNoOfOpenSlots("bike"));
        System.out.println("Available truck slots: " + parkingLot.getNoOfOpenSlots("truck"));
        System.out.println();

        // Test 2: Park some vehicles
        System.out.println("--- Test 2: Parking Vehicles ---");
        System.out.println("Parking a red car...");
        String carTicket1 = parkingLot.parkVehicle("car", "MH-01-1234", "red");
        System.out.println("Received ticket: " + carTicket1);

        System.out.println("\nParking a black bike...");
        String bikeTicket1 = parkingLot.parkVehicle("bike", "MH-02-5678", "black");
        System.out.println("Received ticket: " + bikeTicket1);

        System.out.println("\nParking a white truck...");
        String truckTicket1 = parkingLot.parkVehicle("truck", "MH-03-9999", "white");
        System.out.println("Received ticket: " + truckTicket1);
        System.out.println();

        // Test 3: Display current status
        System.out.println("--- Test 3: Current Parking Status ---");
        System.out.println("Available car slots now: " + parkingLot.getNoOfOpenSlots("car"));
        parkingLot.displayOpenSlots("car");
        System.out.println("\nOccupied car slots:");
        parkingLot.displayOccupiedSlots("car");
        System.out.println("\nOccupied truck slots:");
        parkingLot.displayOccupiedSlots("truck");
        System.out.println();

        // Test 4: Unpark a vehicle
        System.out.println("--- Test 4: Unparking Vehicle ---");
        System.out.println("Unparking bike with ticket: " + bikeTicket1);
        parkingLot.unPark(bikeTicket1);
        System.out.println("\nAvailable bike slots after unparking: " + parkingLot.getNoOfOpenSlots("bike"));
        System.out.println();

        // Test 5: Try to park in full section
        System.out.println("--- Test 5: Testing Full Capacity ---");
        System.out.println("Attempting to park 3 more trucks...");
        parkingLot.parkVehicle("truck", "MH-04-1111", "blue");
        parkingLot.parkVehicle("truck", "MH-05-2222", "green");
        String lastTruckTicket = parkingLot.parkVehicle("truck", "MH-06-3333", "yellow");
        
        System.out.println("\nTrying to park one more truck (should fail):");
        String overflowTicket = parkingLot.parkVehicle("truck", "MH-07-4444", "red");
        if (overflowTicket == null) {
            System.out.println("Correctly rejected - no truck slots available!");
        }
        System.out.println();

        // Test 6: Display final status
        System.out.println("--- Test 6: Final Status Check ---");
        System.out.println("All occupied slots:");
        parkingLot.displayOccupiedSlots("car");
        parkingLot.displayOccupiedSlots("bike");
        parkingLot.displayOccupiedSlots("truck");
    }
}

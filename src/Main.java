public class Main {
    public static void main(String[] args) {
        // Initialize parking lot with 3 floors and 10 slots per floor
        ParkingLot parkingLot = new ParkingLot("PR123", 3, 10);
        
        // Park some vehicles
        String ticket1 = parkingLot.parkVehicle("car", "KA01-1234", "red");
        String ticket2 = parkingLot.parkVehicle("bike", "KA02-5678", "black");
        String ticket3 = parkingLot.parkVehicle("truck", "KA03-9999", "white");
        
        System.out.println("Parked vehicles with tickets: " + ticket1 + ", " + ticket2 + ", " + ticket3);
        
        // Display current status
        parkingLot.displayOpenSlots("car");
        parkingLot.displayOccupiedSlots("car");
        
        System.out.println("Open bike slots: " + parkingLot.getNoOfOpenSlots("bike"));
        
        // Unpark a vehicle
        parkingLot.unPark(ticket2);
        
        // Check status after unparking
        System.out.println("Open bike slots after unparking: " + parkingLot.getNoOfOpenSlots("bike"));
        
        // Try to park a truck when no slots are available
        String ticket4 = parkingLot.parkVehicle("truck", "KA04-1111", "blue");
        if (ticket4 == null) {
            System.out.println("Failed to park truck - no available slots");
        }
    }
}

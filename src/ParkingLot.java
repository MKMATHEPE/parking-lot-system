import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<List<Slot>> slots;

    public ParkingLot(String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;
        this.slots = new ArrayList<>();
        
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            
            // First slot for truck
            floorSlots.add(new Slot("truck"));
            
            // Next two slots for bike
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));
            
            // Remaining slots for car
            for (int j = 3; j < noOfSlotsPerFlr; j++) {
                floorSlots.add(new Slot("car"));
            }
        }
    }

    public String parkVehicle(String type, String regNo, String color) {
        Vehicle vehicle = new Vehicle(type, regNo, color);
        
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.getType().equals(type) && !slot.isOccupied()) {
                    String ticketId = generateTicketId(i + 1, j + 1);
                    slot.occupySlot(vehicle, ticketId);
                    return ticketId;
                }
            }
        }
        
        System.out.println("No slot available for given type");
        return null;
    }

    public void unPark(String ticketId) {
        try {
            String[] extract = ticketId.split("_");
            int flr_idx = Integer.parseInt(extract[1]) - 1;
            int slot_idx = Integer.parseInt(extract[2]) - 1;
            
            if (flr_idx < slots.size() && slot_idx < slots.get(flr_idx).size()) {
                Slot slot = slots.get(flr_idx).get(slot_idx);
                if (slot.isOccupied()) {
                    slot.freeSlot();
                    System.out.println("Unparked vehicle with ticket " + ticketId);
                } else {
                    System.out.println("Invalid ticket - slot already empty");
                }
            } else {
                System.out.println("Invalid ticket - no such slot exists");
            }
        } catch (Exception e) {
            System.out.println("Invalid ticket format");
        }
    }

    public int getNoOfOpenSlots(String type) {
        int count = 0;
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (!slot.isOccupied() && slot.getType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayOpenSlots(String type) {
        System.out.println("Open slots for " + type + ":");
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (!slot.isOccupied() && slot.getType().equals(type)) {
                    System.out.println("Floor " + (i + 1) + " slot " + (j + 1));
                }
            }
        }
    }

    public void displayOccupiedSlots(String type) {
        System.out.println("Occupied slots for " + type + ":");
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.isOccupied() && slot.getType().equals(type)) {
                    System.out.println("Floor " + (i + 1) + " slot " + (j + 1) + 
                                      " - Reg: " + slot.getVehicle().getRegistration());
                }
            }
        }
    }

    private String generateTicketId(int flr, int slno) {
        return parkingLotId + "_" + flr + "_" + slno;
    }
}

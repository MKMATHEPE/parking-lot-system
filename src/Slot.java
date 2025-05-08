public class Slot {
    String type;
    Vehicle vehicle;
    String ticketId;
    
    public Slot(String type) {
        this.type = type;
        this.vehicle = null;
        this.ticketId = null;
    }

    // Add methods to check slot status
    public boolean isOccupied() {
        return vehicle != null;
    }

    public void occupySlot(Vehicle vehicle, String ticketId) {
        this.vehicle = vehicle;
        this.ticketId = ticketId;
    }

    public void freeSlot() {
        this.vehicle = null;
        this.ticketId = null;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

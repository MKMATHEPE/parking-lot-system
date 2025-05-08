public class Vehicle {
    String type;
    String registration;
    String color;
    
    public Vehicle(String type, String registration, String color) {
        this.type = type;
        this.registration = registration;
        this.color = color;
    }

    // Add getters for better encapsulation
    public String getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public String getColor() {
        return color;
    }
}

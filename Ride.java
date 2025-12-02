package src;
// Ride.java

public class Ride {
    // At least 3 instance variables
    private String rideName;
    private String rideType; // roller coaster, water ride, etc.
    private Employee operator; // Must include Employee type
    
    // Constructors
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.operator = null;
    }
    
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
    }
    
    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
}
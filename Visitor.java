public class Visitor extends Person {
    // Two exclusive instance variables
    private String ticketNumber;
    private boolean hasFastPass;

    // Default constructor
    public Visitor() {}

    // Parameterized constructor (including parent class attributes)
    public Visitor(String name, int age, String id, String ticketNumber, boolean hasFastPass) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.hasFastPass = hasFastPass;
    }

    // Getters and Setters
    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public boolean isHasFastPass() { return hasFastPass; }
    public void setHasFastPass(boolean hasFastPass) { this.hasFastPass = hasFastPass; }

    // Override toString (for easy printing)
    @Override
    public String toString() {
        return "Visitor{name='" + getName() + "', age=" + getAge() + ", ticket=" + ticketNumber + ", fastPass=" + hasFastPass + "}";
    }
}
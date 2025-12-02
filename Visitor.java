package src;
// Visitor.java

public class Visitor extends Person {
    // At least 2 instance variables
    private String ticketNumber;
    private boolean hasVIPPass;
    
    // Constructors
    public Visitor() {
        super();
        this.ticketNumber = "TKT000";
        this.hasVIPPass = false;
    }
    
    public Visitor(String name, int age, String id,
                  String ticketNumber, boolean hasVIPPass) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.hasVIPPass = hasVIPPass;
    }
    
    // Getters and setters
    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public boolean isHasVIPPass() { return hasVIPPass; }
    public void setHasVIPPass(boolean hasVIPPass) { this.hasVIPPass = hasVIPPass; }
}
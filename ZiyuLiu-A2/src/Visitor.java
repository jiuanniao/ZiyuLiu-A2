public class Visitor {
    private String name;
    private int age;
    private String id;
    private String ticketId; // Corresponds to the previous "Txxxx" field
    private boolean fastPass; // Fast Pass status

    // Constructor (matches previous creation logic)
    public Visitor(String name, int age, String id, String ticketId, boolean fastPass) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.ticketId = ticketId;
        this.fastPass = fastPass;
    }

    // Added missing getter methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }
    public String getTicketId() { return ticketId; } // Fixes "The method getTicketId() is undefined"
    public boolean hasFastPass() { return fastPass; } // Fixes "The method hasFastPass() is undefined"
}
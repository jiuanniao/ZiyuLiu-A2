// Employee.java
public class Employee extends Person {
    // At least 2 instance variables
    private String employeeId;
    private String position; // Job position
    
    // Constructors
    public Employee() {
        super();
        this.employeeId = "EMP000";
        this.position = "Ride Operator";
    }
    
    public Employee(String name, int age, String id, 
                   String employeeId, String position) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.position = position;
    }
    
    // Getters and setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
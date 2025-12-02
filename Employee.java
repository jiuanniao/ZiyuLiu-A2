public class Employee extends Person {
    // Two exclusive instance variables
    private String employeeId;
    private String position;

    // Default constructor
    public Employee() {}

    // Parameterized constructor (including parent class attributes)
    public Employee(String name, int age, String id, String employeeId, String position) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.position = position;
    }

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
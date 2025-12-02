public class Employee {
    private String name;
    private int age;
    private String pId;
    private String eId;
    private String position;
    // Newly added: Accepts the 6th parameter (e.g., "employee level")
    private int empLevel; // Can be named based on your business logic (e.g., empLevel, deptId, etc.)

    // Original 5-parameter constructor
    public Employee(String name, int age, String pId, String eId, String position) {
        this.name = name;
        this.age = age;
        this.pId = pId;
        this.eId = eId;
        this.position = position;
    }

    // Newly added: 6-parameter constructor (adapts to your calls)
    public Employee(String name, int age, String pId, String eId, String position, int empLevel) {
        this.name = name;
        this.age = age;
        this.pId = pId;
        this.eId = eId;
        this.position = position;
        this.empLevel = empLevel; // Bind the 6th parameter
    }

    // Added getters (as needed)
    public String getName() { return name; }
    public int getEmpLevel() { return empLevel; } // Getter for the newly added field
}
package src;
// Person.java
public abstract class Person {
    // At least 3 instance variables
    private String name;
    private int age;
    private String id; // ID number or employee number
    
    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.id = "000000";
    }
    
    // Parameterized constructor
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    // Can add toString method
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", ID: " + id;
    }
}
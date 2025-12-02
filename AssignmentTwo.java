public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }
    public void partThree() {
    // 1. Print test title for easy distinction in the console output
    System.out.println("=== Part3 Waiting Queue Function Test ===");
    
    // 2. Create an operator (Employee object) required for the Ride
    // Call Employee parameterized constructor: name, age, id, employeeId, position
    Employee rideOperator = new Employee("Zhang San", 30, "PER001", "EMP007", "Roller Coaster Operator");
    
    // 3. Create a Ride object (specify name, type, and operator)
    // Depends on Ride's parameterized constructor (which initializes the waitingLine queue)
    Ride rollerCoaster = new Ride("Super Roller Coaster", "Thrilling", rideOperator);
    
    // 4. Add 5 Visitors to the waiting queue (call Ride's addVisitorToQueue method)
    // Each Visitor's parameters: name, age, id, ticketNumber, hasFastPass
    rollerCoaster.addVisitorToQueue(new Visitor("Jack", 20, "VIS001", "TICK1001", false));
    rollerCoaster.addVisitorToQueue(new Visitor("Sharon", 18, "VIS002", "TICK1002", true));
    rollerCoaster.addVisitorToQueue(new Visitor("Benny", 25, "VIS003", "TICK1003", false));
    rollerCoaster.addVisitorToQueue(new Visitor("Leo", 22, "VIS004", "TICK1004", false));
    rollerCoaster.addVisitorToQueue(new Visitor("Lily", 19, "VIS005", "TICK1005", true));
    
    // 5. Print the current waiting queue (verify successful addition)
    System.out.println("\nWaiting queue after adding 5 visitors:");
    rollerCoaster.printQueue();
    
    // 6. Remove 1 visitor from the queue (FIFO principle, remove Jack who was added first)
    System.out.println("\nExecuting removal operation:");
    rollerCoaster.removeVisitorFromQueue();
    
    // 7. Print the queue again (verify successful removal, queue length becomes 4)
    System.out.println("\nWaiting queue after removing 1 visitor:");
    rollerCoaster.printQueue();
}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}
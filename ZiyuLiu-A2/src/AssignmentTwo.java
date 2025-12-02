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
    public void partFourA() {
    System.out.println("\n=== Part4A Test Ride History ===");
    Ride waterRide = new Ride("Water Rafting", "Leisure", new Employee("Li Si", 28, "P456", "E789", "Rafting Operator"));
    // Add 5 visitors to history
    Visitor v1 = new Visitor("Tom", 23, "V006", "T1006", false);
    Visitor v2 = new Visitor("Sherly", 21, "V007", "T1007", true);
    Visitor v3 = new Visitor("Ben", 24, "V008", "T1008", false);
    Visitor v4 = new Visitor("David", 26, "V009", "T1009", false);
    Visitor v5 = new Visitor("Amy", 20, "V010", "T1010", true);
    waterRide.addVisitorToHistory(v1);
    waterRide.addVisitorToHistory(v2);
    waterRide.addVisitorToHistory(v3);
    waterRide.addVisitorToHistory(v4);
    waterRide.addVisitorToHistory(v5);
    // Check if visitors are in history
    waterRide.checkVisitorFromHistory(v2);
    waterRide.checkVisitorFromHistory(new Visitor("Bob", 30, "V011", "T1011", false));
    // Print number of visitors and history details
    waterRide.numberOfVisitors();
    waterRide.printRideHistory();
}

// Add call in main method: assignment.partFourA();
    public void partFourB() {
    System.out.println("\n=== Part4B Test Sorting Ride History ===");
    Ride ferrisWheel = new Ride("Ferris Wheel", "Sightseeing", new Employee("Wang Wu", 35, "P789", "E012", "Ferris Wheel Operator"));
    // Add 5 visitors (age and fast pass randomly generated)
    ferrisWheel.addVisitorToHistory(new Visitor("Alice", 22, "V012", "T1012", true));
    ferrisWheel.addVisitorToHistory(new Visitor("Bob", 19, "V013", "T1013", false));
    ferrisWheel.addVisitorToHistory(new Visitor("Charlie", 22, "V014", "T1014", false));
    ferrisWheel.addVisitorToHistory(new Visitor("Diana", 25, "V015", "T1015", true));
    ferrisWheel.addVisitorToHistory(new Visitor("Ethan", 19, "V016", "T1016", true));
    // Print before sorting
    System.out.println("Before sorting:");
    ferrisWheel.printRideHistory();
    // Sort
    ferrisWheel.sortRideHistory();
    // Print after sorting
    System.out.println("\nAfter sorting:");
    ferrisWheel.printRideHistory();
}

// Add the call in the main method: assignment.partFourB();
    public void partFive() {
    System.out.println("\n=== Part5 Test Ride Cycle ===");
    // Create operator
    Employee operator = new Employee("Zhao Liu", 32, "P012", "E345", "Roller Coaster Operator");
    // Create ride (max 3 people per cycle)
    Ride rollerCoaster = new Ride("Super Roller Coaster", "Thrill", operator, 3);
    // Add 10 visitors to queue
    for (int i = 1; i <= 10; i++) {
        rollerCoaster.addVisitorToQueue(new Visitor("Visitor " + i, 18 + i, "V" + String.format("%03d", i + 20), "T" + String.format("%04d", i + 2000), i % 3 == 0));
    }
    // Print queue before operation
    System.out.println("Waiting queue before operation:");
    rollerCoaster.printQueue();
    // Run one cycle
    rollerCoaster.runOneCycle();
    // Print queue and history after operation
    System.out.println("\nWaiting queue after operation:");
    rollerCoaster.printQueue();
    System.out.println("\nRide history after operation:");
    rollerCoaster.printRideHistory();
}

// Add the call in the main method: assignment.partFive();
    public void partSix() {
    System.out.println("\n=== Part6 Test Exporting Ride History ===");
    Ride carousel = new Ride("Carousel", "Kids' Category", new Employee("Sun Qi", 27, "P345", "E678", "Carousel Operator", 5));
    // Add 5 visitors to history
    carousel.addVisitorToHistory(new Visitor("Mia", 8, "V031", "T2001", true));
    carousel.addVisitorToHistory(new Visitor("Leo", 6, "V032", "T2002", false));
    carousel.addVisitorToHistory(new Visitor("Zoe", 7, "V033", "T2003", true));
    carousel.addVisitorToHistory(new Visitor("Sam", 9, "V034", "T2004", false));
    carousel.addVisitorToHistory(new Visitor("Luna", 7, "V035", "T2005", true));
    // Export to local file (file path can be customized, e.g., "D:/rideHistory.csv")
    carousel.exportRideHistory("rideHistory.csv");
}

// Add the call in the main method: assignment.partSix();
   public void partSeven() {
    System.out.println("\n=== Part7 Test Ride History Import ===");
    Ride carousel = new Ride("Carousel", "Children's Ride", new Employee("Sun Qi", 27, "P345", "E678", "Carousel Operator", 5));
    // Import the file generated in Part6
    carousel.importRideHistory("rideHistory.csv");
    // Verify import result
    System.out.println("Total number of visitors after import: " + carousel.numberOfVisitors());
    System.out.println("Visitor details after import:");
    carousel.printRideHistory();
}

// Add the call in the main method: assignment.partSeven();
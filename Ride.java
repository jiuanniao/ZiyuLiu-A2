import java.util.Queue;
import java.util.LinkedList;
public class Ride implements RideInterface {
    // Three instance variables (including Employee)
    private String rideName;
    private String rideType;
    private Employee operator;
    // Newly added waiting queue variable
private Queue<Visitor> waitingLine;

    // Default constructor
    public Ride() {
        // Initialize the waiting queue (implement the Queue interface using LinkedList)
        this.waitingLine = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
    // Add the visitor to the end of the waiting queue
    waitingLine.add(visitor);
    // Optional: Print a prompt message for debugging
    System.out.println("Visitor [" + visitor.getName() + "] has been added to the waiting queue of [" + this.rideName + "]");
    }

    @Override
    public void removeVisitorFromQueue() {
    if (!waitingLine.isEmpty()) { // First check if the waiting queue is empty
        Visitor removedVisitor = waitingLine.poll();
        System.out.println("Visitor [" + removedVisitor.getName() + "] has left the waiting queue of [" + this.rideName + "]");
    } else {
        System.out.println("The waiting queue of [" + this.rideName + "] is empty; cannot remove any visitor");
    }
    }

    @Override
    public void printQueue() {
    System.out.println("=== Current Waiting Queue of [" + this.rideName + "] ===");
    if (waitingLine.isEmpty()) {
        System.out.println("No visitors in the queue");
        return;
    }
    // Iterate through the queue and print each visitor
    int index = 1;
    for (Visitor visitor : waitingLine) {
        System.out.println(index + ". " + visitor.getName() + " (Visitor ID: " + visitor.getId() + ")");
        index++;
    }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addVisitorToHistory'");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkVisitorFromHistory'");
    }

    @Override
    public int numberOfVisitors() {
    return waitingLine.size();
    }

    @Override
    public void printRideHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printRideHistory'");
    }

    @Override
    public void runOneCycle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runOneCycle'");
    }
}
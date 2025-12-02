import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
// Newly added: IO classes required for CSV reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Ride implements RideInterface {
    // Original instance variables
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> waitingLine;
    private Queue<Visitor> rideHistory;

    // Newly added: Maximum number of riders per cycle
    private int maxRider;
    // Newly added: Number of completed cycles
    private int numOfCycles;

    // Default constructor
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    // Parameterized constructor (3 parameters)
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    // Newly added: Parameterized constructor (4 parameters, supports maxRider)
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Getters and Setters (Original + New)
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Error: Max rider must be a positive number!");
        }
    }
    public int getNumOfCycles() { return numOfCycles; }
    // Newly added: Supports setting total cycles (synchronized when reading CSV)
    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // Add visitor to waiting queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("Visitor [" + visitor.getName() + "] added to waiting queue of [" + this.rideName + "]");
        } else {
            System.out.println("Error: Cannot add null visitor to queue!");
        }
    }

    // Remove visitor from waiting queue
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println("Visitor [" + removedVisitor.getName() + "] removed from waiting queue of [" + this.rideName + "]");
        } else {
            System.out.println("The waiting queue of [" + this.rideName + "] is empty; cannot remove!");
        }
    }

    // Print waiting queue
    @Override
    public void printQueue() {
        System.out.println("\n=== Current Waiting Queue of [" + this.rideName + "] ===");
        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in queue");
            return;
        }
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". " + visitor.getName() + " (ID: " + visitor.getId() + ")");
            index++;
        }
    }

    /**
     * Sort the waiting queue (waitingLine) by age in ascending order, and by fast pass in descending order
     * Note: Queue does not natively support sorting; convert to List first, sort, and the order will take effect directly
     */
    @Override
    public void sortWaitingQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Warning: Waiting queue of [" + this.rideName + "] is empty; no need to sort!");
            return;
        }

        // Fix "Unchecked cast" warning: Explicitly cast to LinkedList (since waitingLine is implemented by LinkedList)
        List<Visitor> visitorList = (LinkedList<Visitor>) waitingLine;
        Collections.sort(visitorList, new VisitorComparator());

        System.out.println("Waiting queue of [" + this.rideName + "] sorted successfully!");
    }

    /**
     * Sort the ride history (rideHistory) by the same rules
     * Logic is consistent with waiting queue sorting; reuse the sorting rule
     */
    @Override
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Warning: Ride history of [" + this.rideName + "] is empty; no need to sort!");
            return;
        }

        // Fix "Unchecked cast" warning: Explicitly cast to LinkedList
        List<Visitor> historyList = (LinkedList<Visitor>) rideHistory;
        Collections.sort(historyList, new VisitorComparator());

        System.out.println("Ride history of [" + this.rideName + "] sorted successfully!");
    }

    // Add visitor to ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Visitor [" + visitor.getName() + "] added to ride history");
        } else {
            System.out.println("Error: Cannot add null visitor to history!");
        }
    }

    // Check if visitor exists in ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null || rideHistory.isEmpty()) {
            return false;
        }
        for (Visitor historyVisitor : rideHistory) {
            if (historyVisitor.getId().equals(visitor.getId())) {
                return true;
            }
        }
        return false;
    }

    // Get number of visitors in waiting queue
    @Override
    public int numberOfVisitors() {
        return waitingLine.size();
    }

    // Print ride history
    @Override
    public void printRideHistory() {
        System.out.println("\n=== Ride History of [" + this.rideName + "] ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have ridden this ride yet");
            return;
        }
        int index = 1;
        for (Visitor visitor : rideHistory) {
            System.out.println(index + ". " + visitor.getName() + " (ID: " + visitor.getId() + ") - Ride Completed");
            index++;
        }
    }

    // Optimized runOneCycle method
    @Override
    public void runOneCycle() {
        int processedCount = 0;

        System.out.println("\n=== [" + this.rideName + "] Starting Run Cycle (" + (numOfCycles + 1) + ") ===");
        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in queue; cycle ended");
            numOfCycles++;
            return;
        }

        while (!waitingLine.isEmpty() && processedCount < this.maxRider) {
            Visitor currentVisitor = waitingLine.poll();
            addVisitorToHistory(currentVisitor);
            processedCount++;
            System.out.println("Visitor [" + currentVisitor.getName() + "] completed the ride");
        }

        numOfCycles++;
        System.out.println("Cycle Ended: Processed " + processedCount + " visitors | Remaining in queue: " + waitingLine.size() + " | Total cycles run: " + numOfCycles);
    }

    /**
     * Export ride history to a CSV file
     * @param filePath The target path of the CSV file (e.g., "ride_history.csv" or "C:/data/ferris_wheel_history.csv")
     * @return true if export succeeds, false if fails
     */
    @Override
    public boolean exportRideHistory(String filePath) {
        // 1. Validate parameter and data legality
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be empty!");
            return false;
        }
        if (rideHistory.isEmpty()) {
            System.out.println("Warning: Ride history is empty; no data to export!");
            return false;
        }

        // 2. Initialize file writer stream (Fix syntax error: Complete the try-with-resources structure)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 3. Write CSV header (defined based on core fields of Visitor and Ride)
            writer.write("RideName,RideType,OperatorName,VisitorName,VisitorID,TicketID,Age,FastPass,RideCycle,ExportTime");
            writer.newLine(); // Line break

            // 4. Traverse ride history and write each data record
            for (Visitor visitor : rideHistory) {
                String line = String.join(",",
                    getRideName(),
                    getRideType(),
                    getOperator().getName(),
                    visitor.getName(),
                    visitor.getId(),
                    visitor.getTicketId(),
                    String.valueOf(visitor.getAge()),
                    String.valueOf(visitor.hasFastPass()),
                    String.valueOf(getNumOfCycles()),
                    LocalDateTime.now().toString()
                );
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Successfully exported ride history to: " + filePath);
            return true;

        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Import ride history from a CSV file (matches the format of exportRideHistory)
     * @param filePath Path of the CSV file to import
     * @return true if import succeeds, false if fails
     */
    @Override
    public boolean importRideHistory(String filePath) {
        // 1. Validate parameter
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be empty!");
            return false;
        }

        // 2. Initialize file reader stream
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;
            // 3. Skip header line (first line)
            reader.readLine();
            lineNum++;

            // 4. Read and parse each data line
            while ((line = reader.readLine()) != null) {
                lineNum++;
                // Split CSV line by comma
                String[] fields = line.split(",");
                // Validate field count (must match 10 fields in header)
                if (fields.length != 10) {
                    System.out.println("Warning: Invalid data format at line " + lineNum + " (expected 10 fields, got " + fields.length + ")");
                    continue;
                }

                // 5. Parse fields to build Visitor object
                try {
                    String visitorName = fields[3];
                    String visitorId = fields[4];
                    String ticketId = fields[5];
                    int age = Integer.parseInt(fields[6]);
                    boolean fastPass = Boolean.parseBoolean(fields[7]);
                    // Parse total cycles (update Ride's numOfCycles)
                    int totalCycles = Integer.parseInt(fields[8]);

                    // 6. Create Visitor and add to rideHistory
                    Visitor visitor = new Visitor(visitorName, age, visitorId, ticketId, fastPass);
                    this.rideHistory.add(visitor);
                    // 7. Sync total cycles from CSV
                    this.setNumOfCycles(totalCycles);

                } catch (NumberFormatException e) {
                    System.out.println("Warning: Failed to parse number at line " + lineNum + ": " + e.getMessage());
                    continue;
                }
            }

            System.out.println("Successfully imported " + this.rideHistory.size() + " records to ride history from: " + filePath);
            return true;

        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
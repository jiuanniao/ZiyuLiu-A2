public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    void sortWaitingQueue();
    void sortRideHistory();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    void runOneCycle();
    boolean exportRideHistory(String filePath);
    boolean importRideHistory(String filePath);
}
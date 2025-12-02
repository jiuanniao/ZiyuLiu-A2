public interface RideInterface {
    // Part3 related methods
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part4 related methods
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part5 related methods
    void runOneCycle();
}
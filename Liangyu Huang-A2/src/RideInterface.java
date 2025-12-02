/**
 * Interface defining the operations that a Ride must implement.
 * This enforces a consistent set of behaviors for all rides in the theme park.
 */
public interface RideInterface {

    // Part 3: Queue operations for waiting visitors
    /**
     * Adds a visitor to the waiting queue.
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a visitor from the waiting queue.
     * @return The removed visitor, or null if queue is empty
     */
    Visitor removeVisitorFromQueue();

    /**
     * Prints all visitors in the waiting queue in FIFO order.
     */
    void printQueue();

    // Part 4A: Ride history operations
    /**
     * Adds a visitor to the ride history.
     * @param visitor The visitor to add to history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a visitor is in the ride history.
     * @param visitor The visitor to check
     * @return true if visitor is in history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the number of visitors who have taken the ride.
     * @return Number of visitors in history
     */
    int numberOfVisitors();

    /**
     * Prints all visitors in the ride history using an Iterator.
     */
    void printRideHistory();

    // Part 5: Run ride operations
    /**
     * Runs the ride for one cycle.
     * Removes visitors from queue and adds them to history.
     */
    void runOneCycle();
}
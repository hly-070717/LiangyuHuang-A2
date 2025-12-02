import java.util.LinkedList;
import java.util.Queue;

/**
 * Class representing a ride in the theme park.
 * Implements RideInterface to ensure consistent behavior.
 */
public class Ride implements RideInterface {
    // Instance variables suitable for a Ride
    private String rideName;
    private String rideType; // e.g., "Roller Coaster", "Water Ride", "Family Ride"
    private int minimumHeight; // in centimeters
    private Employee rideOperator; // Employee assigned to operate this ride

    // Part 3: Queue for waiting visitors
    private Queue<Visitor> waitingQueue;

    // Part 4A: LinkedList for ride history (visitors who have taken the ride)
    private LinkedList<Visitor> rideHistory;

    // Part 5: Ride cycle properties
    private int maxRider;      // Maximum visitors per cycle
    private int numOfCycles;   // Number of times ride has been run

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minimumHeight = 100; // Default 100cm
        this.rideOperator = null; // No operator assigned initially
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;    // Default: 2 visitors per cycle
        this.numOfCycles = 0; // Starts at 0
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int minimumHeight, Employee rideOperator) {
        this();
        this.rideName = rideName;
        this.rideType = rideType;
        this.minimumHeight = minimumHeight;
        this.rideOperator = rideOperator;
    }

    // Parameterized constructor with maxRider
    public Ride(String rideName, String rideType, int minimumHeight,
                Employee rideOperator, int maxRider) {
        this(rideName, rideType, minimumHeight, rideOperator);
        this.maxRider = maxRider;
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // Method to check if ride has an operator assigned
    public boolean hasOperator() {
        return rideOperator != null;
    }

    // Method to check if ride is operational (has operator and operator is on duty)
    public boolean isOperational() {
        return hasOperator() && rideOperator.isOnDuty();
    }

    // ============ Interface Method Implementations ============

    // Part 3: Queue Operations

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot add null visitor to queue.");
            return;
        }

        if (waitingQueue.offer(visitor)) {
            System.out.println("Success: Visitor " + visitor.getName() +
                    " added to " + rideName + " queue.");
        } else {
            System.out.println("Error: Failed to add visitor " + visitor.getName() +
                    " to " + rideName + " queue.");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removedVisitor = waitingQueue.poll();
        if (removedVisitor != null) {
            System.out.println("Success: Visitor " + removedVisitor.getName() +
                    " removed from " + rideName + " queue.");
        } else {
            System.out.println("Info: Queue for " + rideName + " is empty. No visitor to remove.");
        }
        return removedVisitor;
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty.");
            return;
        }

        System.out.println("=== Waiting Queue for " + rideName + " ===");
        System.out.println("Total waiting: " + waitingQueue.size());
        System.out.println("Order (First in → First out):");

        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName() +
                    " (Ticket: " + visitor.getTicketNumber() + ")");
            position++;
        }
        System.out.println();
    }

    // Part 4A: Ride History Operations

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot add null visitor to history.");
            return;
        }

        if (rideHistory.add(visitor)) {
            System.out.println("Success: Visitor " + visitor.getName() +
                    " added to " + rideName + " history.");
        } else {
            System.out.println("Error: Failed to add visitor " + visitor.getName() +
                    " to " + rideName + " history.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot check null visitor.");
            return false;
        }

        boolean found = rideHistory.contains(visitor);
        System.out.println("Info: Visitor " + visitor.getName() +
                (found ? " IS " : " is NOT ") +
                "in " + rideName + " history.");
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Info: " + rideName + " has " + count +
                " visitors in history.");
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty.");
            return;
        }

        System.out.println("=== Ride History for " + rideName + " ===");
        System.out.println("Total visitors: " + rideHistory.size());
        System.out.println("Details:");

        // Using Iterator as required
        java.util.Iterator<Visitor> iterator = rideHistory.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(count + ". " + visitor.getName() +
                    " | Age: " + visitor.getAge() +
                    " | Ticket: " + visitor.getTicketNumber() +
                    " | Pass: " + (visitor.hasSeasonPass() ? "Yes" : "No"));
            count++;
        }
        System.out.println();
    }

    // Part 5: Run Ride Operations

    @Override
    public void runOneCycle() {
        System.out.println("\n=== Attempting to run " + rideName + " for one cycle ===");

        // Check 1: Is there a ride operator?
        if (!hasOperator()) {
            System.out.println("FAIL: Cannot run ride. No operator assigned to " + rideName + ".");
            return;
        }

        // Check 2: Is the operator on duty?
        if (!rideOperator.isOnDuty()) {
            System.out.println("FAIL: Cannot run ride. Operator " + rideOperator.getName() +
                    " is not on duty.");
            return;
        }

        // Check 3: Are there waiting visitors?
        if (waitingQueue.isEmpty()) {
            System.out.println("FAIL: Cannot run ride. No visitors in queue.");
            return;
        }

        // Check 4: Can we run with current maxRider?
        if (maxRider <= 0) {
            System.out.println("FAIL: Cannot run ride. maxRider must be at least 1.");
            return;
        }

        // Determine how many visitors to take this cycle
        int visitorsToTake = Math.min(maxRider, waitingQueue.size());

        System.out.println("SUCCESS: Running " + rideName + " for cycle #" + (numOfCycles + 1));
        System.out.println("Taking " + visitorsToTake + " visitor(s) from queue...");

        // Process visitors
        for (int i = 0; i < visitorsToTake; i++) {
            Visitor visitor = removeVisitorFromQueue();
            if (visitor != null) {
                addVisitorToHistory(visitor);
            }
        }

        // Update cycle count
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
        System.out.println("Visitors remaining in queue: " + waitingQueue.size());
    }

    // Override toString
    @Override
    public String toString() {
        String operatorInfo = (rideOperator != null)
                ? rideOperator.getName() + " (ID: " + rideOperator.getEmployeeId() + ")"
                : "No Operator Assigned";

        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", minimumHeight=" + minimumHeight + "cm" +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", rideOperator=" + operatorInfo +
                ", waitingVisitors=" + waitingQueue.size() +
                ", historyVisitors=" + rideHistory.size() +
                ", isOperational=" + isOperational() +
                '}';
    }
}
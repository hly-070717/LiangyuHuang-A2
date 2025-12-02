import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
        this.waitingQueue = new LinkedList<Visitor>();
        this.rideHistory = new LinkedList<Visitor>();
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

    // Method to get queue size (for Part 3)
    public int getQueueSize() {
        return waitingQueue.size();
    }

    // Method to get history size
    public int getHistorySize() {
        return rideHistory.size();
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
        Iterator<Visitor> iterator = rideHistory.iterator();
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

    // ============ Part 4B: Sorting Methods ============

    /**
     * Sorts the ride history using a Comparator.
     * Part 4B: Sorting the ride history
     *
     * @param comparator the comparator to use for sorting
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("Info: Ride history is empty. Nothing to sort.");
            return;
        }

        if (comparator == null) {
            System.out.println("Error: Comparator cannot be null.");
            return;
        }

        System.out.println("Sorting ride history for " + rideName + "...");
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted successfully.");
    }

    /**
     * Sorts the ride history using the default comparator (by age then name).
     */
    public void sortRideHistory() {
        sortRideHistory(new VisitorComparator());
    }

    /**
     * Sorts the ride history by name and membership type.
     */
    public void sortRideHistoryByName() {
        VisitorComparator.NameComparator nameComparator = new VisitorComparator.NameComparator();
        sortRideHistory(nameComparator);
    }

    /**
     * Sorts the ride history by ticket number and season pass status.
     */
    public void sortRideHistoryByTicket() {
        VisitorComparator.TicketNumberComparator ticketComparator = new VisitorComparator.TicketNumberComparator();
        sortRideHistory(ticketComparator);
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

    // ============ Part 6: Writing to File ============

    /**
     * PART 6: Exports ride history to a CSV file.
     * Writes details of all visitors who have taken the ride to a file.
     * Each visitor's details are written on their own line in CSV format.
     *
     * @param filename The name of the file to write to
     * @return true if export was successful, false otherwise
     */
    public boolean exportRideHistory(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            System.out.println("Error: Filename cannot be null or empty.");
            return false;
        }

        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("Info: Ride history is empty. No data to export.");
            return false;
        }

        BufferedWriter writer = null;
        try {
            // Create BufferedWriter for efficient writing
            writer = new BufferedWriter(new FileWriter(filename));

            System.out.println("Exporting ride history for " + rideName + " to file: " + filename);
            System.out.println("Total visitors to export: " + rideHistory.size());

            int count = 0;
            // Write each visitor's details as a CSV line
            for (Visitor visitor : rideHistory) {
                if (visitor != null) {
                    // Create CSV line: name,age,email,ticketNumber,hasSeasonPass,membershipType
                    String csvLine = String.format("%s,%d,%s,%s,%b,%s",
                            escapeCSV(visitor.getName()),
                            visitor.getAge(),
                            escapeCSV(visitor.getEmail()),
                            escapeCSV(visitor.getTicketNumber()),
                            visitor.hasSeasonPass(),
                            escapeCSV(visitor.getMembershipType()));

                    writer.write(csvLine);
                    writer.newLine();
                    count++;
                }
            }

            writer.close();
            System.out.println("Success: Exported " + count + " visitors to " + filename);
            return true;

        } catch (IOException e) {
            System.out.println("Error: Failed to write to file " + filename);
            System.out.println("Exception: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error: Unexpected error during export");
            System.out.println("Exception: " + e.getMessage());
            return false;
        } finally {
            // Ensure writer is closed
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Warning: Failed to close file writer");
                }
            }
        }
    }

    /**
     * Helper method to escape CSV special characters.
     * Wraps strings containing commas or quotes in double quotes.
     *
     * @param input The string to escape
     * @return The escaped CSV string
     */
    private String escapeCSV(String input) {
        if (input == null) {
            return "";
        }

        // If string contains comma, double quote, or newline, wrap in quotes
        if (input.contains(",") || input.contains("\"") || input.contains("\n")) {
            // Escape double quotes by doubling them
            String escaped = input.replace("\"", "\"\"");
            return "\"" + escaped + "\"";
        }

        return input;
    }

    /**
     * Overloaded version that uses default filename based on ride name.
     *
     * @return true if export was successful, false otherwise
     */
    public boolean exportRideHistory() {
        String defaultFilename = rideName.replaceAll("\\s+", "_") + "_history.csv";
        return exportRideHistory(defaultFilename);
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
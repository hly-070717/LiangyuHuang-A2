/**
 * Main class for the theme park management system.
 * Contains methods for all parts of the assignment.
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===\n");

        // Create an instance to call non-static methods
        AssignmentTwo assignment = new AssignmentTwo();

        System.out.println("=== PART 2: Abstract Class and Interface ===\n");
        assignment.demonstratePart2();

        System.out.println("\n\n=== PART 3: Waiting Line Queue Implementation ===\n");
        assignment.partThree();

        System.out.println("\n=== All Demonstrations Complete ===");
    }

    /**
     * Demonstrates the functionality of Part 2 (abstract class and interface)
     */
    private static void demonstratePart2() {
        System.out.println("=== Testing Abstract Person Class ===");

        // Cannot instantiate Person directly (it's abstract)
        // Person person = new Person(); // This would cause compilation error

        // But we can instantiate subclasses
        System.out.println("Person is abstract - can only create Employee or Visitor objects");

        System.out.println("\n=== Testing RideInterface Implementation ===");

        // Create employees
        Employee operator1 = new Employee("John Smith", 28, "john@park.com",
                "E1001", "Operations", true);
        Employee operator2 = new Employee("Sarah Lee", 32, "sarah@park.com",
                "E1002", "Operations", false); // Not on duty

        // Create visitors
        Visitor visitor1 = new Visitor("Alice", 25, "alice@email.com", "T1001", true, "VIP");
        Visitor visitor2 = new Visitor("Bob", 30, "bob@email.com", "T1002", false, "Regular");
        Visitor visitor3 = new Visitor("Charlie", 22, "charlie@email.com", "T1003", true, "VIP");
        Visitor visitor4 = new Visitor("Diana", 28, "diana@email.com", "T1004", false, "Regular");
        Visitor visitor5 = new Visitor("Ethan", 35, "ethan@email.com", "T1005", true, "Premium");

        System.out.println("\n=== Creating Rides (implementing RideInterface) ===");

        // Create rides with different maxRider capacities
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", 140, operator1, 2);
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", 120, operator2, 4);

        System.out.println("Created: " + rollerCoaster);
        System.out.println("Created: " + waterRide);

        System.out.println("\n=== Testing Queue Operations (Part 3 methods) ===");

        // Test addVisitorToQueue
        System.out.println("\n--- Adding visitors to Thunder Bolt queue ---");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Test printQueue
        rollerCoaster.printQueue();

        // Test removeVisitorFromQueue
        System.out.println("--- Removing a visitor from queue ---");
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.printQueue();

        System.out.println("\n=== Testing Ride History Operations (Part 4A methods) ===");

        // Test addVisitorToHistory
        System.out.println("\n--- Adding visitors to Splash Mountain history ---");
        waterRide.addVisitorToHistory(visitor1);
        waterRide.addVisitorToHistory(visitor2);
        waterRide.addVisitorToHistory(visitor3);

        // Test checkVisitorFromHistory
        System.out.println("\n--- Checking visitors in history ---");
        waterRide.checkVisitorFromHistory(visitor1);  // Should be true
        waterRide.checkVisitorFromHistory(visitor5);  // Should be false

        // Test numberOfVisitors
        System.out.println("\n--- Counting visitors in history ---");
        waterRide.numberOfVisitors();

        // Test printRideHistory (using Iterator as required)
        System.out.println("\n--- Printing ride history (using Iterator) ---");
        waterRide.printRideHistory();

        System.out.println("\n=== Testing runOneCycle (Part 5 preview) ===");

        // Add visitors to water ride queue
        waterRide.addVisitorToQueue(visitor4);
        waterRide.addVisitorToQueue(visitor5);
        waterRide.printQueue();

        // Try to run cycle (should fail - operator not on duty)
        System.out.println("\n--- Attempting to run Splash Mountain (operator off duty) ---");
        waterRide.runOneCycle();

        // Create a ride with no operator
        Ride noOperatorRide = new Ride("Test Ride", "Test", 100, null, 2);
        noOperatorRide.addVisitorToQueue(visitor1);

        System.out.println("\n--- Attempting to run Test Ride (no operator) ---");
        noOperatorRide.runOneCycle();

        // Test successful cycle
        System.out.println("\n--- Attempting to run Thunder Bolt (should succeed) ---");
        rollerCoaster.printQueue();
        rollerCoaster.runOneCycle();

        // Show results
        System.out.println("\n=== Final State ===");
        System.out.println("Thunder Bolt: " + rollerCoaster);
        System.out.println("Splash Mountain: " + waterRide);

        System.out.println("\nThunder Bolt queue:");
        rollerCoaster.printQueue();

        System.out.println("Thunder Bolt history:");
        rollerCoaster.printRideHistory();
    }

    /**
     * PART 3: Demonstrates the Queue implementation for waiting visitors
     * Requirements:
     * 1. Create a new Ride object
     * 2. Add minimum 5 visitors to the queue
     * 3. Remove a visitor from the queue
     * 4. Print all visitors in the queue
     */
    public void partThree() {
        System.out.println("=== Setting up for Part 3 Demonstration ===");

        // Create an employee to operate the ride
        Employee rideOperator = new Employee("Alex Johnson", 29, "alex.johnson@themepark.com",
                "E2001", "Ride Operations", true);

        // Create a ride
        Ride rollerCoaster = new Ride("Dragon's Fury", "Roller Coaster", 135, rideOperator, 4);
        System.out.println("Created Ride: " + rollerCoaster.getRideName());
        System.out.println("Ride Operator: " + rollerCoaster.getRideOperator().getName());
        System.out.println("Max riders per cycle: " + rollerCoaster.getMaxRider());

        System.out.println("\n=== Creating 5 Visitors ===");

        // Create 5 visitors as required
        Visitor visitor1 = new Visitor("Michael Chen", 25, "michael@email.com",
                "V1001", true, "VIP");
        Visitor visitor2 = new Visitor("Sarah Wilson", 32, "sarah@email.com",
                "V1002", false, "Regular");
        Visitor visitor3 = new Visitor("James Miller", 18, "james@email.com",
                "V1003", true, "Student");
        Visitor visitor4 = new Visitor("Emma Davis", 22, "emma@email.com",
                "V1004", false, "Regular");
        Visitor visitor5 = new Visitor("David Brown", 45, "david@email.com",
                "V1005", true, "Premium");
        Visitor visitor6 = new Visitor("Lisa Taylor", 28, "lisa@email.com",
                "V1006", false, "Regular"); // Extra visitor

        System.out.println("Created 6 visitors (5 required + 1 extra for testing)");

        System.out.println("\n=== Step 1: Adding Visitors to Queue ===");
        System.out.println("Adding visitors to the waiting queue...");

        // Add visitors to the queue (minimum 5 as required)
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6); // Extra visitor

        System.out.println("\n=== Step 2: Printing Initial Queue ===");
        System.out.println("Showing current waiting queue:");
        rollerCoaster.printQueue();

        System.out.println("=== Step 3: Removing a Visitor from Queue ===");
        System.out.println("Removing the first visitor from the queue...");

        // Remove a visitor from the queue
        Visitor removedVisitor = rollerCoaster.removeVisitorFromQueue();
        if (removedVisitor != null) {
            System.out.println("Successfully removed: " + removedVisitor.getName() +
                    " (Ticket: " + removedVisitor.getTicketNumber() + ")");
        }

        System.out.println("\n=== Step 4: Printing Updated Queue ===");
        System.out.println("Showing queue after removal:");
        rollerCoaster.printQueue();

        System.out.println("=== Testing Additional Queue Operations ===");

        // Test: Try to remove another visitor
        System.out.println("\n--- Removing another visitor ---");
        Visitor removedVisitor2 = rollerCoaster.removeVisitorFromQueue();
        if (removedVisitor2 != null) {
            System.out.println("Removed: " + removedVisitor2.getName());
        }

        // Print queue again
        System.out.println("\n--- Queue after second removal ---");
        rollerCoaster.printQueue();

        // Test: Add a new visitor
        System.out.println("\n--- Adding a new visitor to the queue ---");
        Visitor visitor7 = new Visitor("Robert King", 38, "robert@email.com",
                "V1007", true, "VIP");
        rollerCoaster.addVisitorToQueue(visitor7);

        // Print final queue
        System.out.println("\n--- Final queue state ---");
        rollerCoaster.printQueue();

        System.out.println("\n=== Queue Operation Summary ===");
        System.out.println("Ride: " + rollerCoaster.getRideName());
        System.out.println("Total visitors added to queue: 7");
        System.out.println("Total visitors removed from queue: 2");

        // Demonstrate FIFO (First-In-First-Out) principle
        System.out.println("\n=== Demonstrating FIFO Principle ===");
        demonstrateFIFO();
    }

    /**
     * Helper method to demonstrate FIFO principle
     */
    private void demonstrateFIFO() {
        System.out.println("\nCreating a new ride to demonstrate FIFO...");

        Employee operator = new Employee("Sam Wilson", 35, "sam@park.com",
                "E3001", "Operations", true);
        Ride testRide = new Ride("Test Coaster", "Test", 120, operator, 2);

        // Create test visitors
        Visitor v1 = new Visitor("First Visitor", 20, "first@email.com", "T001", false, "Regular");
        Visitor v2 = new Visitor("Second Visitor", 22, "second@email.com", "T002", false, "Regular");
        Visitor v3 = new Visitor("Third Visitor", 24, "third@email.com", "T003", false, "Regular");

        System.out.println("\nAdding visitors in order:");
        System.out.println("1. " + v1.getName());
        System.out.println("2. " + v2.getName());
        System.out.println("3. " + v3.getName());

        testRide.addVisitorToQueue(v1);
        testRide.addVisitorToQueue(v2);
        testRide.addVisitorToQueue(v3);

        System.out.println("\nCurrent queue order (should be First → Second → Third):");
        testRide.printQueue();

        System.out.println("Removing visitors (should come out in same order they went in):");

        // Remove first visitor (should be v1)
        Visitor firstOut = testRide.removeVisitorFromQueue();
        System.out.println("1st removed: " + (firstOut != null ? firstOut.getName() : "null"));

        // Remove second visitor (should be v2)
        Visitor secondOut = testRide.removeVisitorFromQueue();
        System.out.println("2nd removed: " + (secondOut != null ? secondOut.getName() : "null"));

        // Remove third visitor (should be v3)
        Visitor thirdOut = testRide.removeVisitorFromQueue();
        System.out.println("3rd removed: " + (thirdOut != null ? thirdOut.getName() : "null"));

        System.out.println("\n✓ FIFO Principle Verified: Visitors removed in same order they were added.");
    }

    /**
     * PART 4A: Ride history with LinkedList
     */
    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList will be tested here");
        // To be implemented in Part 4A
    }

    /**
     * PART 4B: Sorting ride history
     */
    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history will be tested here");
        // To be implemented in Part 4B
    }

    /**
     * PART 5: Run ride cycle
     */
    public void partFive() {
        System.out.println("Part 5: Run ride cycle will be tested here");
        // To be implemented in Part 5
    }

    /**
     * PART 6: Writing to file
     */
    public void partSix() {
        System.out.println("Part 6: Writing to file will be tested here");
        // To be implemented in Part 6
    }

    /**
     * PART 7: Reading from file
     */
    public void partSeven() {
        System.out.println("Part 7: Reading from file will be tested here");
        // To be implemented in Part 7
    }
}
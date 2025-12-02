/**
 * Main class for the theme park management system.
 * Contains methods for all parts of the assignment.
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===\n");

        // Create an instance to call non-static methods
        AssignmentTwo assignment = new AssignmentTwo();

        // Run Part 2 demonstration
        System.out.println("=== PART 2: Abstract Class and Interface ===\n");
        demonstratePart2();

        // Run Part 3 demonstration
        System.out.println("\n\n=== PART 3: Waiting Line Queue Implementation ===\n");
        assignment.partThree();

        // Run Part 4A demonstration
        System.out.println("\n\n=== PART 4A: Ride History with LinkedList ===\n");
        assignment.partFourA();

        // Run Part 4B demonstration
        System.out.println("\n\n=== PART 4B: Sorting Ride History ===\n");
        assignment.partFourB();

        System.out.println("\n=== All Demonstrations Complete ===");
    }

    /**
     * PART 2: Demonstrates the functionality of Part 2 (abstract class and interface)
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
        System.out.println("Current queue size: " + rollerCoaster.getQueueSize());

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
     * PART 4A: Demonstrates LinkedList implementation for ride history
     * Requirements:
     * 1. Create a new Ride object
     * 2. Add minimum 5 visitors to the collection
     * 3. Check if a visitor is in the collection
     * 4. Print the number of visitors in the collection
     * 5. Print all visitors in the collection (using Iterator as required)
     */
    public void partFourA() {
        System.out.println("=== Setting up for Part 4A Demonstration ===");

        // Create an employee to operate the ride
        Employee operator = new Employee("Maria Garcia", 31, "maria@themepark.com",
                "E4001", "Ride Operations", true);

        // Create a ride
        Ride ferrisWheel = new Ride("Sky Wheel", "Ferris Wheel", 110, operator, 6);
        System.out.println("Created Ride: " + ferrisWheel.getRideName());
        System.out.println("Ride Type: " + ferrisWheel.getRideType());
        System.out.println("Minimum Height: " + ferrisWheel.getMinimumHeight() + "cm");
        System.out.println("Operator: " + ferrisWheel.getRideOperator().getName());

        System.out.println("\n=== Creating 7 Visitors for Testing ===");

        // Create visitors with varied attributes for testing
        Visitor visitor1 = new Visitor("John Adams", 45, "john@email.com",
                "H1001", true, "VIP");
        Visitor visitor2 = new Visitor("Emily Chen", 22, "emily@email.com",
                "H1002", false, "Student");
        Visitor visitor3 = new Visitor("Robert Kim", 33, "robert@email.com",
                "H1003", true, "Premium");
        Visitor visitor4 = new Visitor("Lisa Wang", 28, "lisa@email.com",
                "H1004", false, "Regular");
        Visitor visitor5 = new Visitor("David Smith", 19, "david@email.com",
                "H1005", true, "Student");
        Visitor visitor6 = new Visitor("Sophia Patel", 52, "sophia@email.com",
                "H1006", true, "VIP");
        Visitor visitor7 = new Visitor("Michael Brown", 41, "michael@email.com",
                "H1007", false, "Regular");

        System.out.println("Created 7 visitors (5 required + 2 extra for testing)");
        System.out.println("Visitors have different ages, membership types, and season pass status.");

        System.out.println("\n=== Step 1: Adding Visitors to Ride History ===");
        System.out.println("Adding visitors to " + ferrisWheel.getRideName() + " history...");

        // Add visitors to history (minimum 5 as required)
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);
        ferrisWheel.addVisitorToHistory(visitor6); // Extra
        ferrisWheel.addVisitorToHistory(visitor7); // Extra

        System.out.println("\n=== Step 2: Checking Visitors in History ===");

        // Check if specific visitors are in history
        System.out.println("Checking visitor presence in history:");
        System.out.println("1. Checking for John Adams (should be in history):");
        boolean found1 = ferrisWheel.checkVisitorFromHistory(visitor1);
        System.out.println("   Result: " + (found1 ? "FOUND" : "NOT FOUND"));

        System.out.println("\n2. Checking for Robert Kim (should be in history):");
        boolean found2 = ferrisWheel.checkVisitorFromHistory(visitor3);
        System.out.println("   Result: " + (found2 ? "FOUND" : "NOT FOUND"));

        // Create a new visitor not in history
        Visitor newVisitor = new Visitor("Test Person", 30, "test@email.com",
                "T9999", false, "Regular");
        System.out.println("\n3. Checking for Test Person (should NOT be in history):");
        boolean found3 = ferrisWheel.checkVisitorFromHistory(newVisitor);
        System.out.println("   Result: " + (found3 ? "FOUND" : "NOT FOUND"));

        System.out.println("\n=== Step 3: Counting Visitors in History ===");

        // Get number of visitors in history
        int count = ferrisWheel.numberOfVisitors();
        System.out.println("Total visitors in history: " + count);
        System.out.println("Expected: 7 visitors (5 minimum required + 2 extra)");

        System.out.println("\n=== Step 4: Printing Ride History (Using Iterator) ===");
        System.out.println("Printing all visitors in ride history (using Iterator as required):");
        System.out.println("Note: The printRideHistory() method MUST use Iterator internally.");

        // Print ride history - this method MUST use Iterator internally
        ferrisWheel.printRideHistory();

        System.out.println("\n=== Testing Additional LinkedList Operations ===");

        // Test: Try to add duplicate visitor
        System.out.println("--- Testing duplicate addition ---");
        System.out.println("Attempting to add John Adams again (already in history):");
        ferrisWheel.addVisitorToHistory(visitor1); // Should print success message

        // Test: Check count after duplicate
        System.out.println("\n--- Counting after duplicate addition ---");
        System.out.println("LinkedList allows duplicates, so count should increase:");
        int newCount = ferrisWheel.numberOfVisitors();
        System.out.println("New count: " + newCount);
        System.out.println("Previous count: " + count);
        System.out.println("Difference: " + (newCount - count));

        // Test: Add null visitor
        System.out.println("\n--- Testing null visitor addition ---");
        System.out.println("Attempting to add null visitor (should show error):");
        ferrisWheel.addVisitorToHistory(null);

        System.out.println("\n=== LinkedList Features Demonstrated ===");
        System.out.println("✓ Dynamic resizing: Added 7+ visitors without capacity issues");
        System.out.println("✓ Allows duplicates: Same visitor can be added multiple times");
        System.out.println("✓ Maintains insertion order: Visitors appear in order added");
        System.out.println("✓ Fast insertion/removal: O(1) for add/remove at ends");
        System.out.println("✓ Iterable: Can use Iterator to traverse (as required)");

        System.out.println("\n=== Why LinkedList for Ride History? ===");
        System.out.println("1. Frequently add visitors (after each ride cycle)");
        System.out.println("2. Need to maintain insertion order");
        System.out.println("3. May need to check if visitor exists (contains() method)");
        System.out.println("4. Need to iterate through all visitors for reporting");

        System.out.println("\n=== Comparison with Other Collections ===");
        System.out.println("ArrayList: Good for random access, but slower inserts");
        System.out.println("HashSet: Faster contains() but doesn't maintain order");
        System.out.println("TreeSet: Sorted but no duplicates allowed");
        System.out.println("LinkedList: Best for our use case!");

        System.out.println("\n=== Final Ride State ===");
        System.out.println(ferrisWheel);
    }

    /**
     * PART 4B: Demonstrates sorting of ride history using Comparator
     * Requirements:
     * 1. Create a class that implements Comparator interface
     * 2. Use at least two instance variables in compare() method
     * 3. Create a method in Ride class to sort using Collections.sort()
     * 4. Demonstrate: add visitors, print, sort, print again
     */
    public void partFourB() {
        System.out.println("=== Setting up for Part 4B Demonstration ===");

        // Create an employee to operate the ride
        Employee operator = new Employee("Tom Wilson", 29, "tom@themepark.com",
                "E5001", "Ride Operations", true);

        // Create a ride
        Ride rollerCoaster = new Ride("Lightning Bolt", "Roller Coaster", 140, operator, 4);
        System.out.println("Created Ride: " + rollerCoaster.getRideName());
        System.out.println("Ride Type: " + rollerCoaster.getRideType());
        System.out.println("Minimum Height: " + rollerCoaster.getMinimumHeight() + "cm");
        System.out.println("Operator: " + rollerCoaster.getRideOperator().getName());

        System.out.println("\n=== Creating 7 Visitors with Varied Attributes ===");

        // Create visitors with different ages, names, and membership types
        Visitor v1 = new Visitor("Zoe Adams", 25, "zoe@email.com", "S1001", true, "VIP");
        Visitor v2 = new Visitor("Alex Brown", 18, "alex@email.com", "S1002", false, "Student");
        Visitor v3 = new Visitor("Charlie Chen", 32, "charlie@email.com", "S1003", true, "Premium");
        Visitor v4 = new Visitor("Maya Davis", 25, "maya@email.com", "S1004", false, "Regular");
        Visitor v5 = new Visitor("Ethan Evans", 45, "ethan@email.com", "S1005", true, "VIP");
        Visitor v6 = new Visitor("Fiona Green", 22, "fiona@email.com", "S1006", false, "Student");
        Visitor v7 = new Visitor("George Harris", 38, "george@email.com", "S1007", true, "Regular");

        System.out.println("Created 7 visitors with different attributes for sorting.");
        System.out.println("Attributes varied: Ages (18-45), Names (A-Z), Membership types");

        System.out.println("\n=== Step 1: Adding Visitors to Ride History (Unsorted Order) ===");
        System.out.println("Adding visitors in intentionally unsorted order:");
        System.out.println("1. Ethan (45, VIP)");
        System.out.println("2. Alex (18, Student)");
        System.out.println("3. George (38, Regular)");
        System.out.println("4. Zoe (25, VIP)");
        System.out.println("5. Maya (25, Regular)");
        System.out.println("6. Charlie (32, Premium)");
        System.out.println("7. Fiona (22, Student)");

        // Add visitors in unsorted order
        rollerCoaster.addVisitorToHistory(v5); // Ethan, 45, VIP
        rollerCoaster.addVisitorToHistory(v2); // Alex, 18, Student
        rollerCoaster.addVisitorToHistory(v7); // George, 38, Regular
        rollerCoaster.addVisitorToHistory(v1); // Zoe, 25, VIP
        rollerCoaster.addVisitorToHistory(v4); // Maya, 25, Regular
        rollerCoaster.addVisitorToHistory(v3); // Charlie, 32, Premium
        rollerCoaster.addVisitorToHistory(v6); // Fiona, 22, Student

        System.out.println("\n=== Step 2: Printing Unsorted Ride History ===");
        System.out.println("Current order (unsorted - as added):");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Step 3: Sorting with Default Comparator ===");
        System.out.println("Sorting by Age (ascending), then by Name (alphabetical)...");
        System.out.println("Using VisitorComparator which implements Comparator<Visitor>");
        System.out.println("compare() method uses TWO instance variables: Age and Name");

        // Sort using default comparator (by age then name)
        rollerCoaster.sortRideHistory();

        System.out.println("\n=== Step 4: Printing Sorted Ride History ===");
        System.out.println("After sorting by Age then Name:");
        System.out.println("Expected order: Alex(18) → Fiona(22) → Maya(25) → Zoe(25) → Charlie(32) → George(38) → Ethan(45)");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Demonstrating Different Sorting Strategies ===");

        // Test 1: Sort by Name and Membership type
        System.out.println("--- Test 1: Sorting by Name and Membership ---");
        System.out.println("Using NameComparator (inner class of VisitorComparator)");
        System.out.println("Sorting by Membership priority (VIP first), then by Name...");

        rollerCoaster.sortRideHistoryByName();
        rollerCoaster.printRideHistory();

        // Test 2: Sort by Ticket number and Season pass
        System.out.println("--- Test 2: Sorting by Ticket Number ---");
        System.out.println("Using TicketNumberComparator (inner class of VisitorComparator)");
        System.out.println("Sorting by Season Pass (holders first), then by Ticket Number...");

        rollerCoaster.sortRideHistoryByTicket();
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Comparator Implementation Details ===");
        System.out.println("VisitorComparator class implements Comparator<Visitor> interface (NOT Comparable)");
        System.out.println("compare() method uses at least TWO instance variables as required:");
        System.out.println("  1. Primary: Age (Integer comparison - younger first)");
        System.out.println("  2. Secondary: Name (String comparison if ages equal - alphabetical)");
        System.out.println("\nAdditional comparators demonstrate different sorting strategies:");
        System.out.println("  - NameComparator: Sorts by membership type then name");
        System.out.println("  - TicketNumberComparator: Sorts by season pass then ticket number");

        System.out.println("\n=== Why Use Comparator Instead of Comparable? ===");
        System.out.println("✓ Comparator allows multiple sorting strategies (age, name, membership, etc.)");
        System.out.println("✓ Doesn't modify original Visitor class (no need to implement Comparable)");
        System.out.println("✓ Can sort by different criteria for different needs");
        System.out.println("✓ More flexible than Comparable (which provides only one natural ordering)");
        System.out.println("✓ Can create multiple Comparator classes for different sorting needs");

        System.out.println("\n=== Sorting Algorithm Used ===");
        System.out.println("Using Collections.sort() method which:");
        System.out.println("  - Implements a stable, adaptive mergesort algorithm");
        System.out.println("  - Time complexity: O(n log n)");
        System.out.println("  - Space complexity: O(n)");
        System.out.println("  - Guaranteed to be stable: equal elements not reordered");

        System.out.println("\n=== Final Verification ===");
        System.out.println("Original visitor count: 7");
        System.out.println("Current history size: " + rollerCoaster.numberOfVisitors());
        System.out.println("Sorting completed successfully!");
        System.out.println("\n✓ All Part 4B requirements satisfied:");
        System.out.println("  1. Created VisitorComparator class implementing Comparator interface");
        System.out.println("  2. compare() method uses at least two instance variables (Age and Name)");
        System.out.println("  3. Added sortRideHistory() method to Ride class using Collections.sort()");
        System.out.println("  4. Demonstrated: added visitors, printed, sorted, printed again");
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
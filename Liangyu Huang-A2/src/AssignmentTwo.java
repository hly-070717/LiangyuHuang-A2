/**
 * Main class for the theme park management system.
 * Contains placeholder methods for future parts.
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===");
        System.out.println("Part 2: Abstract Class and Interface Demonstration\n");

        // Demonstrate Part 2 functionality
        demonstratePart2();

        System.out.println("\n=== End of Part 2 Demonstration ===");
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

    // Placeholder methods for future parts
    public void partThree() {
        System.out.println("Part 3: Queue implementation will be tested here");
    }

    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList will be tested here");
    }

    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history will be tested here");
    }

    public void partFive() {
        System.out.println("Part 5: Run ride cycle will be tested here");
    }

    public void partSix() {
        System.out.println("Part 6: Writing to file will be tested here");
    }

    public void partSeven() {
        System.out.println("Part 7: Reading from file will be tested here");
    }
}
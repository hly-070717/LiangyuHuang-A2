
/**
 * Main class for the theme park management system.
 * Contains placeholder methods for future parts.
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===");
        System.out.println("Part 1: Classes and Inheritance Demonstration\n");

        // Demonstrate Part 1 functionality
        demonstratePart1();

        System.out.println("\n=== End of Part 1 Demonstration ===");
    }

    /**
     * Demonstrates the functionality of Part 1 classes
     */
    private static void demonstratePart1() {
        // Create an Employee
        Employee operator = new Employee("John Smith", 28, "john.smith@themepark.com",
                "E1001", "Ride Operations", true);
        System.out.println("Created Employee: " + operator);

        // Create a Visitor
        Visitor visitor1 = new Visitor("Alice Johnson", 25, "alice@email.com",
                "T2001", true, "VIP");
        System.out.println("Created Visitor: " + visitor1);

        // Create another Visitor
        Visitor visitor2 = new Visitor("Bob Williams", 12, "bob@email.com",
                "T2002", false, "Child");
        System.out.println("Created Visitor: " + visitor2);

        // Create a Ride with the employee as operator
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", 140, operator);
        System.out.println("Created Ride: " + rollerCoaster);

        // Create another Ride without an operator
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", 120, null);
        System.out.println("Created Ride: " + waterRide);

        // Demonstrate getters and setters
        System.out.println("\n=== Demonstrating Getters and Setters ===");

        // Change ride operator
        Employee newOperator = new Employee("Sarah Davis", 32, "sarah@themepark.com",
                "E1002", "Ride Operations", true);
        rollerCoaster.setRideOperator(newOperator);
        System.out.println("Updated Ride Operator: " + rollerCoaster.getRideOperator().getName());

        // Change visitor details
        visitor1.setAge(26);
        visitor1.setMembershipType("Premium VIP");
        System.out.println("Updated Visitor: " + visitor1);

        // Check ride operational status
        System.out.println("Roller Coaster is operational: " + rollerCoaster.isOperational());
        System.out.println("Water Ride is operational: " + waterRide.isOperational());
    }

    // Placeholder methods for future parts (as specified in the brief)
    public void partThree() {
        // To be implemented in Part 3
    }

    public void partFourA() {
        // To be implemented in Part 4A
    }

    public void partFourB() {
        // To be implemented in Part 4B
    }

    public void partFive() {
        // To be implemented in Part 5
    }

    public void partSix() {
        // To be implemented in Part 6
    }

    public void partSeven() {
        // To be implemented in Part 7
    }
}
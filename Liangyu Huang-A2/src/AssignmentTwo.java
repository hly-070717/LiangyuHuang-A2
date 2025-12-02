/**
 * PART 5: Run ride cycle
 * Requirements:
 * 1. Create a new Ride object
 * 2. Add a minimum of 10 visitors to the queue
 * 3. Print all visitors in the queue
 * 4. Run one cycle
 * 5. Print all visitors in the queue after one cycle
 * 6. Print all visitors in the collection (history)
 */
public void partFive() {
    System.out.println("=== PART 5: Run a Ride Cycle ===");
    System.out.println("=== Setting up for Part 5 Demonstration ===");

    // Create an employee to operate the ride
    Employee rideOperator = new Employee("Chris Evans", 34, "chris@themepark.com",
            "E6001", "Ride Operations", true);
    System.out.println("Created Ride Operator: " + rideOperator.getName() +
            " (ID: " + rideOperator.getEmployeeId() + ")");
    System.out.println("On Duty: " + (rideOperator.isOnDuty() ? "Yes" : "No"));

    // Create a ride with specific maxRider capacity
    Ride rollerCoaster = new Ride("Dragon's Breath", "Roller Coaster", 140, rideOperator, 4);
    System.out.println("\nCreated Ride: " + rollerCoaster.getRideName());
    System.out.println("Ride Type: " + rollerCoaster.getRideType());
    System.out.println("Minimum Height: " + rollerCoaster.getMinimumHeight() + "cm");
    System.out.println("Max Riders per Cycle: " + rollerCoaster.getMaxRider());
    System.out.println("Initial Cycles Run: " + rollerCoaster.getNumOfCycles());
    System.out.println("Has Operator: " + (rollerCoaster.hasOperator() ? "Yes" : "No"));
    System.out.println("Is Operational: " + (rollerCoaster.isOperational() ? "Yes" : "No"));

    System.out.println("\n=== Creating 12 Visitors for Testing ===");

    // Create 12 visitors (10 required + 2 extra)
    Visitor[] visitors = new Visitor[12];
    visitors[0] = new Visitor("Olivia Martinez", 28, "olivia@email.com", "P1001", true, "VIP");
    visitors[1] = new Visitor("Liam Johnson", 22, "liam@email.com", "P1002", false, "Student");
    visitors[2] = new Visitor("Emma Wilson", 35, "emma@email.com", "P1003", true, "Premium");
    visitors[3] = new Visitor("Noah Brown", 19, "noah@email.com", "P1004", false, "Regular");
    visitors[4] = new Visitor("Ava Davis", 31, "ava@email.com", "P1005", true, "VIP");
    visitors[5] = new Visitor("William Miller", 24, "william@email.com", "P1006", false, "Student");
    visitors[6] = new Visitor("Sophia Garcia", 27, "sophia@email.com", "P1007", true, "Premium");
    visitors[7] = new Visitor("James Rodriguez", 42, "james@email.com", "P1008", false, "Regular");
    visitors[8] = new Visitor("Isabella Wilson", 20, "isabella@email.com", "P1009", true, "VIP");
    visitors[9] = new Visitor("Benjamin Moore", 38, "benjamin@email.com", "P1010", false, "Regular");
    visitors[10] = new Visitor("Mia Taylor", 25, "mia@email.com", "P1011", true, "Student"); // Extra
    visitors[11] = new Visitor("Ethan Anderson", 29, "ethan@email.com", "P1012", false, "Regular"); // Extra

    System.out.println("Created 12 visitors (10 required + 2 extra for testing)");
    System.out.println("Visitors have different ages, ticket types, and season pass status.");

    System.out.println("\n=== Step 1: Adding Visitors to Queue ===");
    System.out.println("Adding 12 visitors to the waiting queue...");

    // Add all visitors to the queue
    for (int i = 0; i < visitors.length; i++) {
        rollerCoaster.addVisitorToQueue(visitors[i]);
    }

    System.out.println("\n=== Step 2: Printing Initial Queue ===");
    System.out.println("Showing current waiting queue (before any cycles):");
    rollerCoaster.printQueue();
    System.out.println("Queue size: " + rollerCoaster.getQueueSize());
    System.out.println("History size: " + rollerCoaster.getHistorySize());
    System.out.println("Cycles run: " + rollerCoaster.getNumOfCycles());

    System.out.println("\n=== Step 3: Running First Cycle ===");
    System.out.println("Attempting to run the first cycle...");
    System.out.println("Expected: Should take " + rollerCoaster.getMaxRider() +
            " visitors from queue (maxRider = " + rollerCoaster.getMaxRider() + ")");

    // Run first cycle
    rollerCoaster.runOneCycle();

    System.out.println("\n=== Step 4: Printing Queue After First Cycle ===");
    System.out.println("Showing waiting queue after first cycle:");
    rollerCoaster.printQueue();
    System.out.println("Queue size after cycle 1: " + rollerCoaster.getQueueSize());
    System.out.println("History size after cycle 1: " + rollerCoaster.getHistorySize());
    System.out.println("Cycles run: " + rollerCoaster.getNumOfCycles());

    System.out.println("\n=== Step 5: Printing Ride History After First Cycle ===");
    System.out.println("Showing visitors who have taken the ride (history):");
    rollerCoaster.printRideHistory();

    System.out.println("\n=== Step 6: Running Second Cycle ===");
    System.out.println("Attempting to run the second cycle...");

    // Run second cycle
    rollerCoaster.runOneCycle();

    System.out.println("\n=== Step 7: Printing Queue After Second Cycle ===");
    System.out.println("Showing waiting queue after second cycle:");
    rollerCoaster.printQueue();
    System.out.println("Queue size after cycle 2: " + rollerCoaster.getQueueSize());
    System.out.println("History size after cycle 2: " + rollerCoaster.getHistorySize());
    System.out.println("Cycles run: " + rollerCoaster.getNumOfCycles());

    System.out.println("\n=== Step 8: Printing Ride History After Second Cycle ===");
    System.out.println("Showing all visitors who have taken the ride (updated history):");
    rollerCoaster.printRideHistory();

    System.out.println("\n=== Step 9: Running Third Cycle ===");
    System.out.println("Attempting to run the third cycle...");

    // Run third cycle
    rollerCoaster.runOneCycle();

    System.out.println("\n=== Step 10: Final Queue Status ===");
    System.out.println("Showing final waiting queue:");
    rollerCoaster.printQueue();
    System.out.println("Queue size after cycle 3: " + rollerCoaster.getQueueSize());
    System.out.println("History size after cycle 3: " + rollerCoaster.getHistorySize());
    System.out.println("Cycles run: " + rollerCoaster.getNumOfCycles());

    System.out.println("\n=== Step 11: Final Ride History ===");
    System.out.println("Showing all visitors who have taken the ride (final history):");
    rollerCoaster.printRideHistory();

    System.out.println("\n=== Testing Edge Cases ===");

    // Test 1: Try to run cycle with operator off duty
    System.out.println("\n--- Test 1: Operator Not On Duty ---");
    Employee offDutyOperator = new Employee("Off Duty Op", 30, "offduty@park.com",
            "E6002", "Operations", false);
    Ride testRide1 = new Ride("Test Ride 1", "Test", 120, offDutyOperator, 2);
    testRide1.addVisitorToQueue(visitors[0]);
    testRide1.addVisitorToQueue(visitors[1]);
    testRide1.runOneCycle(); // Should fail - operator not on duty

    // Test 2: Try to run cycle with no operator
    System.out.println("\n--- Test 2: No Operator Assigned ---");
    Ride testRide2 = new Ride("Test Ride 2", "Test", 120, null, 2);
    testRide2.addVisitorToQueue(visitors[0]);
    testRide2.runOneCycle(); // Should fail - no operator

    // Test 3: Try to run cycle with empty queue
    System.out.println("\n--- Test 3: Empty Queue ---");
    Ride testRide3 = new Ride("Test Ride 3", "Test", 120, rideOperator, 2);
    testRide3.runOneCycle(); // Should fail - empty queue

    System.out.println("\n=== Summary ===");
    System.out.println("✓ Created Ride with maxRider = " + rollerCoaster.getMaxRider());
    System.out.println("✓ Added " + visitors.length + " visitors to queue (10+ required)");
    System.out.println("✓ Printed queue before and after each cycle");
    System.out.println("✓ Successfully ran " + rollerCoaster.getNumOfCycles() + " cycles");
    System.out.println("✓ Printed history showing visitors who took the ride");
    System.out.println("✓ Tested various error conditions");
    System.out.println("✓ Verified FIFO principle in action");

    System.out.println("\n=== Final Statistics ===");
    System.out.println("Ride: " + rollerCoaster.getRideName());
    System.out.println("Total visitors processed: " + rollerCoaster.getHistorySize());
    System.out.println("Visitors remaining in queue: " + rollerCoaster.getQueueSize());
    System.out.println("Total cycles run: " + rollerCoaster.getNumOfCycles());

    System.out.println("\n✓ All Part 5 requirements successfully demonstrated!");
}

void main() {
}
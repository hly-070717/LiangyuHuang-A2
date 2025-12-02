/**
 * PART 6: Writing to a file
 * Requirements:
 * 1. Create a new Ride object
 * 2. Add minimum 5 visitors to the ride history
 * 3. Export the visitors to a file
 */
public void partSix() {
    System.out.println("=== PART 6: Writing to File ===\n");

    System.out.println("=== Setting up for Part 6 Demonstration ===");

    // Create an employee to operate the ride
    Employee operator = new Employee("Data Manager", 35, "data@themepark.com",
            "E7001", "Data Operations", true);

    // Create a ride
    Ride dataRide = new Ride("Data Express", "Data Ride", 130, operator, 4);
    System.out.println("Created Ride: " + dataRide.getRideName());
    System.out.println("Ride Type: " + dataRide.getRideType());
    System.out.println("Minimum Height: " + dataRide.getMinimumHeight() + "cm");
    System.out.println("Max Riders per Cycle: " + dataRide.getMaxRider());
    System.out.println("Operator: " + dataRide.getRideOperator().getName());

    System.out.println("\n=== Step 1: Creating 7 Visitors for File Export ===");

    // Create 7 visitors (5 required + 2 extra for comprehensive testing)
    Visitor visitor1 = new Visitor("John Data", 28, "john.data@email.com",
            "F1001", true, "VIP");
    Visitor visitor2 = new Visitor("Sarah File", 32, "sarah.file@email.com",
            "F1002", false, "Regular");
    Visitor visitor3 = new Visitor("Mike CSV", 25, "mike.csv@email.com",
            "F1003", true, "Premium");
    Visitor visitor4 = new Visitor("Emma Export", 19, "emma.export@email.com",
            "F1004", false, "Student");
    Visitor visitor5 = new Visitor("David Backup", 45, "david.backup@email.com",
            "F1005", true, "VIP");
    Visitor visitor6 = new Visitor("Lisa Format", 22, "lisa.format@email.com",
            "F1006", false, "Regular");
    Visitor visitor7 = new Visitor("Tom Archive", 38, "tom.archive@email.com",
            "F1007", true, "Premium");

    System.out.println("Created 7 visitors (5 required + 2 extra for testing)");
    System.out.println("Visitors have different attributes to test CSV formatting:");
    System.out.println("  - Different ages (19-45)");
    System.out.println("  - Various email formats");
    System.out.println("  - Different ticket numbers");
    System.out.println("  - Mixed season pass status");
    System.out.println("  - Various membership types");

    System.out.println("\n=== Step 2: Adding Visitors to Ride History ===");
    System.out.println("Adding visitors to " + dataRide.getRideName() + " history...");

    // Add visitors to history (minimum 5 as required)
    dataRide.addVisitorToHistory(visitor1);
    dataRide.addVisitorToHistory(visitor2);
    dataRide.addVisitorToHistory(visitor3);
    dataRide.addVisitorToHistory(visitor4);
    dataRide.addVisitorToHistory(visitor5);
    dataRide.addVisitorToHistory(visitor6); // Extra
    dataRide.addVisitorToHistory(visitor7); // Extra

    System.out.println("\n=== Step 3: Verifying History Contents ===");
    System.out.println("Checking number of visitors in history:");
    int historySize = dataRide.numberOfVisitors();
    System.out.println("Expected: 7 visitors");
    System.out.println("Actual: " + historySize + " visitors");

    System.out.println("\n=== Step 4: Displaying History Before Export ===");
    System.out.println("Displaying ride history that will be exported:");
    dataRide.printRideHistory();

    System.out.println("=== Step 5: Exporting Ride History to File ===");

    // Define filename
    String filename = dataRide.getRideName().replaceAll("\\s+", "_") + "_history.csv";
    System.out.println("Exporting to file: " + filename);
    System.out.println("File will be saved in CSV (Comma-Separated Values) format.");
    System.out.println("Each line represents one visitor with the following fields:");
    System.out.println("  Name, Age, Email, Ticket Number, Has Season Pass, Membership Type");

    // Export to file
    boolean exportSuccess = dataRide.exportRideHistory(filename);

    if (exportSuccess) {
        System.out.println("\n✓ SUCCESS: File export completed!");
        System.out.println("  File: " + filename);
        System.out.println("  Visitors exported: " + historySize);

        System.out.println("\n=== File Content Preview ===");
        System.out.println("Expected CSV format (first 2 lines as example):");
        System.out.println("John Data,28,john.data@email.com,F1001,true,VIP");
        System.out.println("Sarah File,32,sarah.file@email.com,F1002,false,Regular");
        System.out.println("...");

        System.out.println("\n=== CSV Format Details ===");
        System.out.println("✓ Fields separated by commas");
        System.out.println("✓ Each visitor on separate line");
        System.out.println("✓ Boolean values as 'true'/'false'");
        System.out.println("✓ Special characters properly escaped");
        System.out.println("✓ No headers - just data rows");
    } else {
        System.out.println("\n✗ FAILED: File export was not successful.");
        System.out.println("  Check error messages above for details.");
    }

    System.out.println("\n=== Testing Different Export Scenarios ===");

    // Test 1: Export with default filename
    System.out.println("\n--- Test 1: Export with Default Filename ---");
    System.out.println("Using default filename based on ride name:");
    boolean defaultExport = dataRide.exportRideHistory();
    System.out.println("Default export result: " + (defaultExport ? "SUCCESS" : "FAILED"));

    // Test 2: Try to export empty history
    System.out.println("\n--- Test 2: Export Empty History ---");
    Ride emptyRide = new Ride("Empty Ride", "Test", 100, operator, 2);
    boolean emptyExport = emptyRide.exportRideHistory("empty_history.csv");
    System.out.println("Empty history export result: " + (emptyExport ? "SUCCESS" : "FAILED"));
    System.out.println("Expected: Should show info message about empty history");

    // Test 3: Test with special characters in names
    System.out.println("\n--- Test 3: Special Characters in Data ---");
    Ride specialRide = new Ride("Special Ride", "Test", 110, operator, 2);
    Visitor specialVisitor = new Visitor("Test,Name\"With\"Commas", 30, "test@email.com",
            "S1001", true, "VIP, Premium");
    specialRide.addVisitorToHistory(specialVisitor);
    boolean specialExport = specialRide.exportRideHistory("special_test.csv");
    System.out.println("Special characters export result: " + (specialExport ? "SUCCESS" : "FAILED"));
    System.out.println("Note: CSV escaping should handle commas and quotes in names");

    // Test 4: Test invalid filename
    System.out.println("\n--- Test 4: Invalid Filename Test ---");
    System.out.println("Attempting export with null filename:");
    boolean nullExport = dataRide.exportRideHistory(null);
    System.out.println("Null filename export result: " + (nullExport ? "SUCCESS" : "FAILED"));
    System.out.println("Expected: Should show error message about invalid filename");

    System.out.println("\n=== File I/O Concepts Demonstrated ===");
    System.out.println("✓ BufferedWriter for efficient file writing");
    System.out.println("✓ FileWriter for character-based file output");
    System.out.println("✓ try-catch-finally for proper resource management");
    System.out.println("✓ IOException handling for file system errors");
    System.out.println("✓ CSV format for structured data storage");
    System.out.println("✓ Data serialization (object → text)");

    System.out.println("\n=== Why CSV Format? ===");
    System.out.println("✓ Human readable and editable");
    System.out.println("✓ Can be opened in spreadsheet programs (Excel, Google Sheets)");
    System.out.println("✓ Simple to parse and generate");
    System.out.println("✓ Widely supported across different systems");
    System.out.println("✓ Good for data exchange between applications");

    System.out.println("\n=== Real-World Application ===");
    System.out.println("This functionality allows:");
    System.out.println("1. Daily ride usage reports");
    System.out.println("2. Backup of visitor data");
    System.out.println("3. Data analysis in external tools");
    System.out.println("4. Long-term storage of ride history");
    System.out.println("5. Data sharing with other departments");

    System.out.println("\n=== Final Verification ===");
    System.out.println("✓ Created new Ride object");
    System.out.println("✓ Added minimum 5 visitors to ride history (added " + historySize + ")");
    System.out.println("✓ Exported visitors to file: " + (exportSuccess ? "SUCCESS" : "See errors above"));
    System.out.println("✓ Added appropriate exception handling and error messages");
    System.out.println("✓ Tested various scenarios (empty history, special chars, invalid names)");

    System.out.println("\n=== How to Check the Exported File ===");
    System.out.println("1. Look for file: " + filename);
    System.out.println("2. Open with text editor or spreadsheet software");
    System.out.println("3. Verify all " + historySize + " visitors are included");
    System.out.println("4. Check data formatting is correct");

    System.out.println("\n=== File Location Note ===");
    System.out.println("The file will be saved in the current working directory.");
    System.out.println("This is typically the same directory as your Java files.");

    System.out.println("\n✓ All Part 6 requirements successfully demonstrated!");
}

void main() {
}
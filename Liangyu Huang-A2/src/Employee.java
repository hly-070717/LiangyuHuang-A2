

/**
 * Class representing theme park staff who operate rides.
 * Extends the Person class.
 */
public class Employee extends Person {
    // Instance variables suitable for theme park staff
    private String employeeId;
    private String department;
    private boolean isOnDuty;

    // Default constructor
    public Employee() {
        super(); // Calls Person default constructor
        this.employeeId = "E0000";
        this.department = "Not Assigned";
        this.isOnDuty = false;
    }

    // Parameterized constructor
    public Employee(String name, int age, String email,
                    String employeeId, String department, boolean isOnDuty) {
        super(name, age, email); // Calls Person parameterized constructor
        this.employeeId = employeeId;
        this.department = department;
        this.isOnDuty = isOnDuty;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean isOnDuty) {
        this.isOnDuty = isOnDuty;
    }

    // Override toString to include employee-specific info
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", isOnDuty=" + isOnDuty +
                '}';
    }
}


/**
 * Class representing theme park visitors.
 * Extends the Person class.
 */
public class Visitor extends Person {
    // Instance variables suitable for theme park visitors
    private String ticketNumber;
    private boolean hasSeasonPass;
    private String membershipType; // e.g., "Regular", "VIP", "Child"

    // Default constructor
    public Visitor() {
        super(); // Calls Person default constructor
        this.ticketNumber = "T0000";
        this.hasSeasonPass = false;
        this.membershipType = "Regular";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String email,
                   String ticketNumber, boolean hasSeasonPass, String membershipType) {
        super(name, age, email); // Calls Person parameterized constructor
        this.ticketNumber = ticketNumber;
        this.hasSeasonPass = hasSeasonPass;
        this.membershipType = membershipType;
    }

    // Getters and setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean hasSeasonPass() {
        return hasSeasonPass;
    }

    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    // Override toString to include visitor-specific info
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", hasSeasonPass=" + hasSeasonPass +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }
}
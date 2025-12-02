
/**
 * Class representing a ride in the theme park.
 */
public class Ride {
    // Instance variables suitable for a Ride
    private String rideName;
    private String rideType; // e.g., "Roller Coaster", "Water Ride", "Family Ride"
    private int minimumHeight; // in centimeters
    private Employee rideOperator; // Employee assigned to operate this ride

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minimumHeight = 100; // Default 100cm
        this.rideOperator = null; // No operator assigned initially
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int minimumHeight, Employee rideOperator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minimumHeight = minimumHeight;
        this.rideOperator = rideOperator;
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

    // Method to check if ride has an operator assigned
    public boolean hasOperator() {
        return rideOperator != null;
    }

    // Method to check if ride is operational (has operator and operator is on duty)
    public boolean isOperational() {
        return hasOperator() && rideOperator.isOnDuty();
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
                ", rideOperator=" + operatorInfo +
                ", isOperational=" + isOperational() +
                '}';
    }
}
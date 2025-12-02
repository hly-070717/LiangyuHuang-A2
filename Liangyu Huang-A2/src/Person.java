/**
 * Abstract class representing a person in the theme park system.
 * This class will never be instantiated directly.
 */
public abstract class Person {
    // Instance variables suitable for a person
    private String name;
    private int age;
    private String email;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "no-email@example.com";
    }

    // Parameterized constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional: toString method for easy printing
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
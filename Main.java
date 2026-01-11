import java.util.Scanner;

public class StudentValidationTest {

    // Custom Exception (Inner Class)
    static class InvalidStudentException extends Exception {
        public InvalidStudentException(String message) {
            super(message);
        }
    }

    // Validation Method
    static void validateStudent(int age, String dept)
            throws InvalidStudentException {

        if (age < 18 || age > 60) {
            throw new InvalidStudentException(
                    "Invalid Age! Age must be between 18 and 60.");
        }

        if (!(dept.equalsIgnoreCase("CSE")
                || dept.equalsIgnoreCase("EEE")
                || dept.equalsIgnoreCase("BBA"))) {

            throw new InvalidStudentException(
                    "Invalid Department! Allowed: CSE, EEE, BBA.");
        }
    }

    // Main Method (Testing Exception Handling)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Department: ");
        String dept = sc.next();

        try {
            validateStudent(age, dept);
            System.out.println("Student data is VALID ✅");
        }
        catch (InvalidStudentException e) {
            System.out.println("Validation Error ❌");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Validation Completed.");
        }
    }
}

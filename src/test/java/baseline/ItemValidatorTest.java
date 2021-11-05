package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemValidatorTest {

    @Test
    void testValidateDescriptionLengthTooLong() {
        // Create an ItemValidator object.
        // Create a string of length 257.
        // Test the method to ensure it returns false.
    }

    @Test
    void testValidateDescriptionLengthTooShort() {
        // Create an ItemValidator object.
        // Create a string of length 0.
        // Test the method to ensure it returns false.
    }

    @Test
    void testValidateDescriptionLengthValidLength() {
        // Create an ItemValidator object.
        // Create a string of length 10.
        // Test the method to ensure it returns true.
    }

    @Test
    void testValidateDateValidDate() {
        // Create an ItemValidator object.
        // Create a string of the date 2021-11-04
        // Test the method to ensure it returns true.
    }

    @Test
    void testValidateDateInvalidDate() {
        // Create an ItemValidator object.
        // Create a string of the date 2021-02-31
        // Test the method to ensure it returns false.
    }
}
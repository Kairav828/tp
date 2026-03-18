package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's student ID in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStudentId(String)}.
 * Format: 9 characters - 1 letter, 7 digits, 1 letter (e.g. A0123456X). Case-insensitive.
 */
public class StudentId {

    public static final String MESSAGE_CONSTRAINTS =
            "Student ID should be 9 characters: 1 letter, 7 digits, 1 letter (e.g. A0123456X).";

    // NUS-style: letter + 7 digits + letter
    public static final String VALIDATION_REGEX = "^[A-Za-z][0-9]{7}[A-Za-z]$";

    public final String value;

    /**
     * Constructs a {@code StudentId}.
     *
     * @param studentId A valid student ID.
     */
    public StudentId(String studentId) {
        requireNonNull(studentId);
        String normalized = studentId.trim().toUpperCase();
        checkArgument(isValidStudentId(normalized), MESSAGE_CONSTRAINTS);
        value = normalized;
    }

    /**
     * Returns true if a given string is a valid student ID.
     */
    public static boolean isValidStudentId(String test) {
        return test != null && test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof StudentId)) {
            return false;
        }
        StudentId otherStudentId = (StudentId) other;
        return value.equals(otherStudentId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

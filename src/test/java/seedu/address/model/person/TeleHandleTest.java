package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TeleHandleTest {

    @Test
    public void isValidTeleHandle() {
        // null
        assertFalse(TeleHandle.isValidTeleHandle(null));

        // invalid formats
        assertFalse(TeleHandle.isValidTeleHandle("")); // empty
        assertFalse(TeleHandle.isValidTeleHandle("notAHandle")); // missing '@'
        assertFalse(TeleHandle.isValidTeleHandle("@ab")); // too short
        assertFalse(TeleHandle.isValidTeleHandle("@has-hyphen")); // invalid char

        // valid
        assertTrue(TeleHandle.isValidTeleHandle("@abcde"));
        assertTrue(TeleHandle.isValidTeleHandle("@abcde_123"));
    }
}


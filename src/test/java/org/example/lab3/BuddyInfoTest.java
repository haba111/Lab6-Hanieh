package org.example.lab3;

import org.example.lab3.entities.BuddyInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {

    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        buddy = new BuddyInfo("sara", "123-456-7890");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("sara", buddy.getName());
        assertEquals("123-456-7890", buddy.getPhoneNumber());
    }

    @Test
    void testSetName() {
        buddy.setName("sara");
        assertEquals("sara", buddy.getName());
    }

    @Test
    void testSetPhoneNumber() {
        buddy.setPhoneNumber("987-654-3210");
        assertEquals("987-654-3210", buddy.getPhoneNumber());
    }

    @Test
    void testToString() {
        String expected = "Name: sara, Phone Number: 123-456-7890";
        assertEquals(expected, buddy.toString());
    }

    @Test
    void testChangeValuesAndToString() {
        buddy.setName("sara K");
        buddy.setPhoneNumber("555-000-1111");
        String expected = "Name: sara K, Phone Number: 555-000-1111";
        assertEquals(expected, buddy.toString());
    }
}

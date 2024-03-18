package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesInArrayTest {

    @Test
    void removeDuplicates() {
        int[] nums1 = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] expected1 = {1, 2, 3, 4, 5};
        int length1 = RemoveDuplicatesInArray.removeDuplicates(nums1);
        assertArrayEquals(expected1, Arrays.copyOf(nums1, length1));
        assertEquals(expected1.length, length1);

        int[] nums2 = {1, 1, 1, 1, 1};
        int[] expected2 = {1};
        int length2 = RemoveDuplicatesInArray.removeDuplicates(nums2);
        assertArrayEquals(expected2, Arrays.copyOf(nums2, length2));
        assertEquals(expected2.length, length2);

    }
}
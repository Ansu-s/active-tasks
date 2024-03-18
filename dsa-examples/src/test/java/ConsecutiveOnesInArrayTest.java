package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveOnesInArrayTest {

    @Test
    void consecutiveCount() {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int count = 3;
        assertEquals(count, ConsecutiveOnesInArray.consecutiveCount(nums1));

        int[] nums2 = {0, 0, 0, 0, 0};
        int count1 = 0;
        assertEquals(count1, ConsecutiveOnesInArray.consecutiveCount(nums2));
    }
}
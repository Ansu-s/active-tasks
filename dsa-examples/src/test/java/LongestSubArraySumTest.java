package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubArraySumTest {

    @Test
    void getLongestSubarray() {
        int[] a1 = {5, 13, 55, 1, 9, 4, 1, 5, 10};
        long k1 = 10;
        int length = 3;
        assertEquals(length, LongestSubArraySum.getLongestSubarray(a1, k1));

    }
}
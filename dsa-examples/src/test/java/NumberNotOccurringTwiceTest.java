package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NumberNotOccurringTwiceTest {

    @Test
    void singleNum() {
        int[] nums1 = {4, 3, 2, 4, 1, 3, 2};
        int missingNum = 1;
        assertEquals(missingNum, NumberNotOccurringTwice.singleNum(nums1));

        int[] nums2 = {1, 1, 2, 2, 3, 3, 4};
        int missingNum1 = 4;
        assertEquals(missingNum1, NumberNotOccurringTwice.singleNum(nums2));
    }
}
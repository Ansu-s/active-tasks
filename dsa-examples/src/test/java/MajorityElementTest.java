package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void findMajorityElement() {
        int[] nums1 = {3, 2, 3};
        assertEquals(3, MajorityElement.findMajorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, MajorityElement.findMajorityElement(nums2));
    }
}
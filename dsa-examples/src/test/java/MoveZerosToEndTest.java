package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosToEndTest {

    @Test
    void moveZeros() {
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] movedArray = {1, 3, 12, 0, 0};
        MoveZerosToEnd.moveZeros(nums1);
        assertArrayEquals(movedArray, nums1);
    }
}
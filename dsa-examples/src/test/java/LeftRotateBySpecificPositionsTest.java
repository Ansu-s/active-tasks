package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeftRotateBySpecificPositionsTest {

    @Test
    void leftRotate() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int n1 = 2;
        int[] expected1 = {3, 4, 5, 1, 2};
        LeftRotateBySpecificPositions.leftRotate(arr1, n1);
        assertArrayEquals(expected1, arr1);

        int[] arr2 = {1, 2, 3, 4, 5};
        int n2 = 4;
        int[] expected2 = {5, 1, 2, 3, 4};
        LeftRotateBySpecificPositions.leftRotate(arr2, n2);
        assertArrayEquals(expected2, arr2);
    }
}
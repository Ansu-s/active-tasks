package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void linearSearch() {
        int[] arr1 = {4, 7, 2, 9, 5};
        int num = 9;
        int expectedIndex1 = 3;
        assertEquals(expectedIndex1, LinearSearch.linearSearch(arr1, num));

        int[] arr2 = {4, 7, 2, 9, 5};
        int num1 = 6;
        int expectedIndex2 = -1;
        assertEquals(expectedIndex2, LinearSearch.linearSearch(arr2, num1));
    }
}
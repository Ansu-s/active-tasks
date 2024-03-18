package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondSmallestElementTest {

    @Test
    void secondLargest() {
        int[] arr1 = {5, 3, 9, 10, 2, 8};
        assertEquals(3, SecondSmallestElement.secondLargest(arr1));

        int[] arr2 = {5, 5, 5, 5};
        assertEquals(5, SecondSmallestElement.secondLargest(arr2));

        int[] arr3 = {1, 2, 3, 4, 5};
        assertEquals(2, SecondSmallestElement.secondLargest(arr3));

        int[] arr4 = {5, 4, 3, 2, 1};
        assertEquals(2, SecondSmallestElement.secondLargest(arr4));
    }
}
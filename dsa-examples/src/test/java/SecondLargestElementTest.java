package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SecondLargestElementTest {

    @Test
    public void secondLargest() {
        int[] arr1 = {5, 3, 9, 10, 2, 8};
        assertEquals(9, SecondLargestElement.secondLargest(arr1));

        int[] arr2 = {5, 5, 5, 5};
        assertEquals(5, SecondLargestElement.secondLargest(arr2));

        int[] arr4 = {5, 4, 3, 2, 1};
        assertEquals(4, SecondLargestElement.secondLargest(arr4));

        int[] arr5 = {1};
        assertEquals(Integer.MIN_VALUE, SecondLargestElement.secondLargest(arr5));

    }
}
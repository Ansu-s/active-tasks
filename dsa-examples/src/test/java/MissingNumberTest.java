package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    void missingNum() {
        int[] arr1 = {1, 2, 4, 5};
        int num1 = 5;
        int result = 3;
        assertEquals(result, MissingNumber.missingNum(arr1, num1));


        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num2 = 10;
        int missingNum = 10;
        assertEquals(missingNum, MissingNumber.missingNum(arr2, num2));
    }
}
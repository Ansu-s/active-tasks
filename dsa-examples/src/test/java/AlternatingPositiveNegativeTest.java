package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternatingPositiveNegativeTest {

    @Test
    void alternatingPositiveNegative() {
        int[] arr1 = {1, 2, -4, -5, 6, -5};
        int[] arrangedArray = {1, -4, 2, -5, 6, -5};
        assertArrayEquals(arrangedArray, AlternatingPositiveNegative.alternatingPositiveNegative(arr1));
    }
}
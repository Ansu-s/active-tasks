package org.example;

import java.util.Arrays;

public class SecondSmallestElement {
    public static int secondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Not enough elements to compare to");
            return Integer.MIN_VALUE;
        }
        Arrays.sort(arr);
        return arr[1];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 10, 2, 8, 1, 1};
        System.out.println("Second smallest element: " + secondLargest(arr));
    }
}

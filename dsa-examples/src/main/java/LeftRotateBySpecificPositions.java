package org.example;

import java.util.Arrays;

public class LeftRotateBySpecificPositions {


    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void leftRotate(int[] arr, int n) {
        int len = arr.length;
        n %= len;


        reverse(arr, 0, n - 1);


        reverse(arr, n, len - 1);


        reverse(arr, 0, len - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 46, 6, 4, 5};
        int n = 6;

        System.out.println("Initial array: " + Arrays.toString(arr));
        leftRotate(arr, n);
        System.out.println("Array after left rotation by " + n + " positions: " + Arrays.toString(arr));
    }
}



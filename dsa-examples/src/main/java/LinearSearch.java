package org.example;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 4, 1, 2, 9, 5};
        int num = 12;
        int result = linearSearch(arr, num);

        if (result != -1) {
            System.out.println("Element " + num + " is at index " + result);
        } else {
            System.out.println("Element " + num + " is not in the array");
        }
    }
}

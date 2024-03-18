package org.example;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void moveZeros(int[] nums) {
        int nonZeroElement = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroElement];
                nums[nonZeroElement] = temp;
                nonZeroElement++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Initial array: " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("Array after moving zeros to the end: " + Arrays.toString(nums));
    }
}

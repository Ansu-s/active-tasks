package org.example;

public class ConsecutiveOnesInArray {
    public static int consecutiveCount(int[] nums) {
        int total = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                total = Math.max(total, count);
            } else {
                count = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Maximum number of consecutive ones: " + consecutiveCount(nums));
    }
}


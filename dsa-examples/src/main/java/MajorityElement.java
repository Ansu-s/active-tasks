package org.example;

public class MajorityElement {
    // using Moore's Voting Algorithm
    public static int findMajorityElement(int[] nums) {
        int majorNum = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorNum) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorNum = nums[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == majorNum) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return majorNum;
        } else {
            throw new IllegalArgumentException("No majority element is present");
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println("Majority element for nums: " + findMajorityElement(nums));

        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element for nums1: " + findMajorityElement(nums1));

        int[] nums2 = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4};
        System.out.println("Majority element for nums2: " + findMajorityElement(nums2));
    }
}

package org.example;


public class RemoveDuplicatesInArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int unique = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique]) {
                unique++;
                nums[unique] = nums[i];
            }
        }

        return unique + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 7, 11, 0};
        int length = removeDuplicates(nums);

        System.out.print("Array without duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}

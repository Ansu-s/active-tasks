package org.example;

import java.util.HashSet;
import java.util.Set;

public class NumberNotOccurringTwice {
    public static int singleNum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (int num : set) {
            return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 5, 4, 5, 1, 3, 2};
        System.out.println("Number occurring once in the array is: " + singleNum(nums));
    }
}


package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static int getLongestSubarray(int[] a, long k) {
        int n = a.length;

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {

            sum += a[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {5, 13, 55, 1, 9, 4, 1, 5, 10};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}

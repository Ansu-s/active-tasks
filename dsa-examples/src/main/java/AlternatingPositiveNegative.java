package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternatingPositiveNegative {

    public static int[] alternatingPositiveNegative(int[] arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : arr) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int posivtiveElementPosition = 0, negativeElementPosition = 0;

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && posivtiveElementPosition < positive.size()) {
                result[i] = positive.get(posivtiveElementPosition++);
            } else if (negativeElementPosition < negative.size()) {
                result[i] = negative.get(negativeElementPosition++);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -4, -5, 6, -5};
        int[] alternatingPositiveNegativeArray = alternatingPositiveNegative(arr1);
        System.out.println(Arrays.toString(alternatingPositiveNegativeArray));
    }
}

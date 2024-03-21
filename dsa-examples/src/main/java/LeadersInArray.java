package org.example;

import java.util.ArrayList;

public class LeadersInArray {

    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int maxRight = arr[n - 1];

        leaders.add(maxRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
                leaders.add(maxRight);
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 0};
        ArrayList<Integer> leaders1 = findLeaders(arr1);
        System.out.println(leaders1);

        int[] arr2 = {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> leaders2 = findLeaders(arr2);
        System.out.println(leaders2);
    }
}

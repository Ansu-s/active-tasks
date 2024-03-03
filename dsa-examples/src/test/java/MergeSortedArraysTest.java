import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArraysTest {
    @Test
    public void testMergeArrays() {

        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6};
        MergeSortedArrays.mergeArrays(arr1, arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr1);
        assertArrayEquals(new int[]{6, 7, 9}, arr2);

        int[] arr3 = {1, 3, 5, 7, 9};
        int[] arr4 = {2, 4, 4, 6};
        MergeSortedArrays.mergeArrays(arr3, arr4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4}, arr3);
        assertArrayEquals(new int[]{5, 6, 7, 9}, arr4);

        int[] arr5 = {-5, -3, -1};
        int[] arr6 = {-4, -2, 0};
        MergeSortedArrays.mergeArrays(arr5, arr6);
        assertArrayEquals(new int[]{-5, -4, -3}, arr5);
        assertArrayEquals(new int[]{-2, -1, 0}, arr6);

        int[] arr7 = {10};
        int[] arr8 = {5};
        MergeSortedArrays.mergeArrays(arr7, arr8);
        assertArrayEquals(new int[]{5}, arr7);
        assertArrayEquals(new int[]{10}, arr8);
    }
}
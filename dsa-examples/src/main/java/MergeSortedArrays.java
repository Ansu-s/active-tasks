import java.util.Arrays;

public class MergeSortedArrays {

    public static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length - 1;
        int m = 0;
        while (n >= 0 && m < arr2.length) {
            if (arr1[n] > arr2[m]) {
                int temp = arr1[n];
                arr1[n] = arr2[m];
                arr2[m] = temp;
                n--;
                m++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 0, -4, 7, -1, 2, 3, 6};
        int[] array2 = {2, 8, 7, 15};
        mergeArrays(array1, array2);
        System.out.println("After merging the sorted first array is :" + Arrays.toString(array1));
        System.out.println("After merging the sorted second array is :" + Arrays.toString(array2));
    }
}

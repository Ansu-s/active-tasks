import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ArrayUnionIntersection {
    public static void main(String[] args) {

        int[] array1 = {1, 2, 5, 5, 4, 6};
        int[] array2 = {1, 2, 5, 8, 15, 4, 6, 9};
        System.out.println("The union is: " + Arrays.toString(unionArray(array1, array2)));
        System.out.println("The intersection is: " + Arrays.toString(intersectionArray(array1, array2)));
    }

    public static int[] unionArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Set<Integer> setmap = new TreeSet<>();
        for (int num : arr1) {
            setmap.add(num);
        }
        for (int num : arr2) {
            setmap.add(num);
        }
        int[] unionArrays = new int[setmap.size()];
        int index = 0;
        for (int num : setmap) {
            unionArrays[index++] = num;
        }
        return unionArrays;
    }

    public static int[] intersectionArray(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int a : arr1) {
            hashSet1.add(a);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hashSet1.contains(arr2[i])) {
                hashSet2.add(arr2[i]);
            }
        }
        int[] intersectedArray = new int[hashSet2.size()];
        int index = 0;
        for (int num : hashSet2) {
            intersectedArray[index] = num;
            index++;
        }
        return intersectedArray;
    }
}
import java.util.Arrays;

public class ArrayCyclicallyRotation {
    public static void main(String[] args) {
        int[] arrray = {1, 25, 5, 45, 0, 6, 3, 1, 0, 6, 0};
        System.out.println(Arrays.toString(rotate(arrray)));
    }

    public static int[] rotate(int[] arr) {
        int lastElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
        return arr;
    }

}

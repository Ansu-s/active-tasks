import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUnionIntersectionTest {

    @Test
    public void test(){

            int[] arr1 = {1, 2, 5, 5, 4, 6};
            int[] arr2 = {1, 2, 5, 8, 15, 4, 6, 9};
            int[] expectedUnion = {1, 2, 4, 5, 6, 8, 9, 15};
            int[] expectedIntersection = {1, 2, 4, 5, 6};

            int[] resultUnion = ArrayUnionIntersection.unionArray(arr1, arr2);
            int[] resultIntersection = ArrayUnionIntersection.intersectionArray(arr1,arr2);
            assertArrayEquals(expectedUnion, resultUnion);
            assertArrayEquals(expectedIntersection, resultIntersection);
        }
    }

}
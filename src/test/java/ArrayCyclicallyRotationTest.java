import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCyclicallyRotationTest {
  @Test
  public void rotateTest() {
      int[] inputArray = {1, 25, 5, 45, 0, 6, 3, 1, 0, 6, 0};
      int[] expectedArray = {0, 1, 25, 5, 45, 0, 6, 3, 1, 0, 6};

      int[] rotatedArray = ArrayCyclicallyRotation.rotate(inputArray);
      assertArrayEquals(expectedArray, rotatedArray);
  }

}
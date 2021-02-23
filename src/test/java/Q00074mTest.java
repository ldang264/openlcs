import org.junit.Test;

import static org.junit.Assert.*;

public class Q00074mTest {

    Q00074m q00074m = new Q00074m();

    @Test
    public void searchMatrix1() {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        for (int i = 0; i < 70; i++) {
            System.out.print(i + "  ");
            System.out.println(q00074m.searchMatrix(matrix, i));
        }
    }
}
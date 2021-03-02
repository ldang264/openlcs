import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00059mTest {

    Q00059m q00059m = new Q00059m();

    @Test
    public void generateMatrix() {
        Assert.assertEquals(Arrays.deepToString(q00059m.generateMatrix(5)),
                "[[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]");
        Assert.assertEquals(Arrays.deepToString(q00059m.generateMatrix(4)), "[[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]");
        Assert.assertEquals(Arrays.deepToString(q00059m.generateMatrix(3)), "[[1, 2, 3], [8, 9, 4], [7, 6, 5]]");
        Assert.assertEquals(Arrays.deepToString(q00059m.generateMatrix(2)), "[[1, 2], [4, 3]]");
        Assert.assertEquals(Arrays.deepToString(q00059m.generateMatrix(1)), "[[1]]");

    }
}
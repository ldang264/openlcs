import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00085hTest {

    Q00085h q00085h = new Q00085h();

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Assert.assertEquals(q00085h.maximalRectangle(matrix), 6);
    }

    @Test
    public void maximalRectangle1() {
        char[][] matrix = new char[][]{{'1', '0', '0', '0', '1'}, {'1', '1', '0', '1', '1'}, {'1', '1', '1', '1', '1'}};
        Assert.assertEquals(q00085h.maximalRectangle(matrix), 5);
    }
}
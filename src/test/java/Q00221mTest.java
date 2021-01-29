import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00221mTest {

    Q00221m q00221m = new Q00221m();

    @Test
    public void maximalSquare() {
        Assert.assertEquals(4, q00221m.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        Assert.assertEquals(1, q00221m.maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
        Assert.assertEquals(0, q00221m.maximalSquare(new char[][]{{'0'}}));
    }
}
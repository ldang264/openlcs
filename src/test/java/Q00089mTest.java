import org.junit.Assert;
import org.junit.Test;

public class Q00089mTest {

    Q00089m q00089m = new Q00089m();

    @Test
    public void grayCode() {
        Assert.assertEquals(q00089m.grayCode(0).toString(), "[0]");
        Assert.assertEquals(q00089m.grayCode(1).toString(), "[0, 1]");
        Assert.assertEquals(q00089m.grayCode(2).toString(), "[0, 1, 3, 2]");
    }
}
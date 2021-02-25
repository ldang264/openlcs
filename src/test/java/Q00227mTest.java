import org.junit.Assert;
import org.junit.Test;

public class Q00227mTest {

    Q00227m q00227m = new Q00227m();

    @Test
    public void calculate() {
        Assert.assertEquals(1, q00227m.calculate("1-1+1"));
        Assert.assertEquals(18, q00227m.calculate("16+ 3 * 5/5 -1"));
        Assert.assertEquals(17, q00227m.calculate("16+ 5 / 3*2 -1"));
        Assert.assertEquals(7, q00227m.calculate("3+2*2"));
        Assert.assertEquals(7, q00227m.calculate(" 3 + 2* 2"));
        Assert.assertEquals(1, q00227m.calculate(" 3/2 "));
        Assert.assertEquals(5, q00227m.calculate(" 3+5 / 2 "));
    }
}
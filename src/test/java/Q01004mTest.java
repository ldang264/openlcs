import org.junit.Assert;
import org.junit.Test;

public class Q01004mTest {

    Q01004m q01004m = new Q01004m();

    @Test
    public void longestOnes() {
        Assert.assertEquals(10, q01004m.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        Assert.assertEquals(9, q01004m.longestOnes(new int[]{1,1,1,0,0,1,1,1,1}, 2));
        Assert.assertEquals(6, q01004m.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        Assert.assertEquals(4, q01004m.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 0));
    }
}
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00901mTest {

    @Test
    public void test() {
        Q00901m q00901m = new Q00901m();
        Assert.assertEquals(q00901m.next(100), 1);
        Assert.assertEquals(q00901m.next(80), 1);
        Assert.assertEquals(q00901m.next(60), 1);
        Assert.assertEquals(q00901m.next(70), 2);
        Assert.assertEquals(q00901m.next(60), 1);
        Assert.assertEquals(q00901m.next(75), 4);
        Assert.assertEquals(q00901m.next(85), 6);
    }

    @Test
    public void test1() {
        Q00901m q00901m = new Q00901m();
        Assert.assertEquals(q00901m.next(1), 1);
        Assert.assertEquals(q00901m.next(2), 2);
        Assert.assertEquals(q00901m.next(3), 3);
    }

}
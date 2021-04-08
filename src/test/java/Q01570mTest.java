import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01570mTest {

    @Test
    public void test1() {
        Q01570m t1 = new Q01570m(new int[]{1, 0, 0, 2, 3});
        Q01570m t2 = new Q01570m(new int[]{0, 3, 0, 4, 0});
        Assert.assertEquals(t1.dotProduct(t2), 8);
    }

    @Test
    public void test2() {
        Q01570m t1 = new Q01570m(new int[]{0, 1, 0, 0, 0});
        Q01570m t2 = new Q01570m(new int[]{0, 0, 0, 0, 2});
        Assert.assertEquals(t1.dotProduct(t2), 0);
    }

    @Test
    public void test3() {
        Q01570m t1 = new Q01570m(new int[]{0, 1, 0, 0, 2, 0, 0});
        Q01570m t2 = new Q01570m(new int[]{1, 0, 0, 0, 3, 0, 4});
        Assert.assertEquals(t1.dotProduct(t2), 6);
    }

}
import org.junit.Assert;
import org.junit.Test;

public class Q00232sTest {

    @Test
    public void test() {
        Q00232s q00232s = new Q00232s();
        q00232s.push(1);
        q00232s.push(2);
        q00232s.push(3);
        q00232s.push(4);
        int i = q00232s.peek();
        Assert.assertEquals(1, i);
        i = q00232s.pop();
        Assert.assertEquals(1, i);
        i = q00232s.pop();
        Assert.assertEquals(2, i);
        i = q00232s.pop();
        Assert.assertEquals(3, i);
        i = q00232s.pop();
        Assert.assertEquals(4, i);
        boolean j = q00232s.empty();
        Assert.assertTrue(j);
    }

}
import org.junit.Assert;
import org.junit.Test;

public class Q00015mClosestTest {

    Q00016m tsc = new Q00016m();

    @Test
    public void testThreeSumClosest() {
        Assert.assertEquals(3, tsc.threeSumClosest(new int[]{1,1,-1,-1,3}, 3));
    }

    @Test
    public void testThreeSumClosest1() {
        Assert.assertEquals(2, tsc.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    @Test
    public void testThreeSumClosest2() {
        Assert.assertEquals(-2, tsc.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
    }

    @Test
    public void testThreeSumClosest3() {
        Assert.assertEquals(82, tsc.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
}
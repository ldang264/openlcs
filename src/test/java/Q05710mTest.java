import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q05710mTest {

    Q05710m q05710m = new Q05710m();

    @Test
    public void getNumberOfBacklogOrders1() {
        int[][] orders = new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
        Assert.assertEquals(q05710m.getNumberOfBacklogOrders(orders), 6);
    }

    @Test
    public void getNumberOfBacklogOrders2() {
        int[][] orders = new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        Assert.assertEquals(q05710m.getNumberOfBacklogOrders(orders), 999999984);
    }

    @Test
    public void getNumberOfBacklogOrders3() {
        int[][] orders = new int[][]{{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}};
        Assert.assertEquals(q05710m.getNumberOfBacklogOrders(orders), 34);
    }
}
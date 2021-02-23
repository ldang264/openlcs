import org.junit.Assert;
import org.junit.Test;

public class Q00054mTest {

    Q00054m q00054m = new Q00054m();

    @Test
    public void spiralOrder() {
        Assert.assertEquals("[1, 2, 3]", q00054m.spiralOrder(new int[][]{{1}, {2}, {3}}).toString());
        Assert.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", q00054m.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}).toString());
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", q00054m.spiralOrder(new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}}).toString());
        Assert.assertEquals("[1, 2]", q00054m.spiralOrder(new int[][]{{1, 2}}).toString());
        Assert.assertEquals("[1]", q00054m.spiralOrder(new int[][]{{1}}).toString());
        Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", q00054m.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toString());
        Assert.assertEquals("[1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]", q00054m.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}}).toString());
    }

}
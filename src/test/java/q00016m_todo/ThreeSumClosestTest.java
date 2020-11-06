package q00016m_todo;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTest {

    ThreeSumClosest tsc = new ThreeSumClosest();

    @Test
    public void testThreeSumClosest() {
        Assert.assertEquals(2, tsc.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(3, tsc.threeSumClosest(new int[]{1,1,-1,-1,3}, 3));
    }

}
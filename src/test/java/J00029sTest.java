import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00029sTest {
    
    J00029s j00029s = new J00029s();

    @Test
    public void spiralOrder() {
        Assert.assertArrayEquals(j00029s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}), new int[]{1,2,3,4,8,12,11,10,9,5,6,7});
        Assert.assertArrayEquals(j00029s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), new int[]{1,2,3,6,9,8,7,4,5});
    }
}
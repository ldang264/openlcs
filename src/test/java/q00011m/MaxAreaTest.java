package q00011m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAreaTest {
    MaxArea ma = new MaxArea();

    @Test
    public void maxArea() {
        Assert.assertEquals(49, ma.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(1, ma.maxArea(new int[]{1,1}));
        Assert.assertEquals(16, ma.maxArea(new int[]{4,3,2,1,4}));
        Assert.assertEquals(2, ma.maxArea(new int[]{1,2,1}));
    }
}
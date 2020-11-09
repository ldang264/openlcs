package q00209m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinSubArrayLenTest {

    MinSubArrayLen msal = new MinSubArrayLen();

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(2, msal.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    @Test
    public void minSubArrayLen1() {
        Assert.assertEquals(3, msal.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    @Test
    public void minSubArrayLen2() {
        Assert.assertEquals(5, msal.minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }

    @Test
    public void minSubArrayLen3() {
        Assert.assertEquals(0, msal.minSubArrayLen(16, new int[]{1,2,3,4,5}));
    }

    @Test
    public void minSubArrayLen4() {
        Assert.assertEquals(3, msal.minSubArrayLen(10, new int[]{1,2,3,4,5}));
    }
}
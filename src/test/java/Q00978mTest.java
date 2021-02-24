import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00978mTest {

    Q00978m q00978m = new Q00978m();

    @Test
    public void maxTurbulenceSize() {
        Assert.assertEquals(2, q00978m.maxTurbulenceSize(new int[]{3,2,1}));
        Assert.assertEquals(1, q00978m.maxTurbulenceSize(new int[]{1,1,1}));
        Assert.assertEquals(3, q00978m.maxTurbulenceSize(new int[]{1,2,1}));
        Assert.assertEquals(2, q00978m.maxTurbulenceSize(new int[]{4,8,12,16}));
        Assert.assertEquals(5, q00978m.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        Assert.assertEquals(1, q00978m.maxTurbulenceSize(new int[]{1}));
        Assert.assertEquals(1, q00978m.maxTurbulenceSize(new int[]{1,1}));
        Assert.assertEquals(2, q00978m.maxTurbulenceSize(new int[]{1,2}));
        Assert.assertEquals(2, q00978m.maxTurbulenceSize(new int[]{1,2,3}));
        Assert.assertEquals(2, q00978m.maxTurbulenceSize(new int[]{1,2,2}));
        Assert.assertEquals(5, q00978m.maxTurbulenceSize(new int[]{1,2,1,2,1}));
    }
}
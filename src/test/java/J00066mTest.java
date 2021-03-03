import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class J00066mTest {

    J00066m j00066m = new J00066m();

    @Test
    public void constructArr() {
        Assert.assertEquals(Arrays.toString(j00066m.constructArr(new int[]{1,2,0,4,5})), "[0, 0, 40, 0, 0]");
        Assert.assertEquals(Arrays.toString(j00066m.constructArr(new int[]{1,2,3,4,5})), "[120, 60, 40, 30, 24]");
        Assert.assertEquals(Arrays.toString(j00066m.constructArr(new int[]{0,2,3,4,5})), "[120, 0, 0, 0, 0]");
    }
}
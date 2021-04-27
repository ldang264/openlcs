import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00053_2sTest {

    J00053_2s j00053_2s = new J00053_2s();

    @Test
    public void missingNumber() {
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{0, 2}), 1);
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{0, 2, 3}), 1);
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{1, 2}), 0);
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{0, 1}), 2);
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{0, 1, 3}), 2);
        Assert.assertEquals(j00053_2s.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}), 8);
    }
}
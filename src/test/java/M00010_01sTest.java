import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class M00010_01sTest {

    M00010_01s m00010_01s = new M00010_01s();

    @Test
    public void merge() {
        int[] A = new int[]{1,2,3,0,0,0}, B = new int[]{2,5,6};
        int m = 3, n = 3;
        m00010_01s.merge(A, m, B, n);
        Assert.assertEquals(Arrays.toString(A), "[1, 2, 2, 3, 5, 6]");
    }
}
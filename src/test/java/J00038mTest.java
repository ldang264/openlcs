import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class J00038mTest {

    J00038m j00038m = new J00038m();

    @Test
    public void permutation() {
        Assert.assertEquals(Arrays.toString(j00038m.permutation("aabc")), "[caab, cbaa, aacb, abca, baca, caba, aabc, acba, abac, acab, baac, bcaa]");
        Assert.assertEquals(Arrays.toString(j00038m.permutation("abc")), "[acb, bca, abc, cba, bac, cab]");
    }
}
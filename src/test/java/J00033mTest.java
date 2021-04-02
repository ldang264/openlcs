import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00033mTest {

    J00033m j00033m = new J00033m();

    @Test
    public void verifyPostorder() {
        Assert.assertFalse(j00033m.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
        Assert.assertTrue(j00033m.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        Assert.assertFalse(j00033m.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }
}
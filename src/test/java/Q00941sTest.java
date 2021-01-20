import org.junit.Assert;
import org.junit.Test;

public class Q00941sTest {

    Q00941s vma = new Q00941s();

    @Test
    public void validMountainArray() {
        Assert.assertFalse(vma.validMountainArray(null));
        Assert.assertFalse(vma.validMountainArray(new int[0]));
        Assert.assertFalse(vma.validMountainArray(new int[] {1}));
        Assert.assertFalse(vma.validMountainArray(new int[] {1, 2}));
        Assert.assertFalse(vma.validMountainArray(new int[] {1, 2, 3}));
        Assert.assertFalse(vma.validMountainArray(new int[] {1, 3, 2, 3}));
        Assert.assertFalse(vma.validMountainArray(new int[] {1, 3, 3, 2}));
        Assert.assertTrue(vma.validMountainArray(new int[] {1, 3, 2}));
    }
}
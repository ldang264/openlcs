package q00941s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidMountainArrayTest {

    ValidMountainArray vma = new ValidMountainArray();

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
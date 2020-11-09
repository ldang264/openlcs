package q00202s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsHappyTest {

    IsHappy ih = new IsHappy();

    @Test
    public void isHappy() {
        Assert.assertTrue(ih.isHappy(1));
        Assert.assertFalse(ih.isHappy(2));
        Assert.assertFalse(ih.isHappy(3));
        Assert.assertFalse(ih.isHappy(4));
        Assert.assertFalse(ih.isHappy(5));
        Assert.assertFalse(ih.isHappy(6));
        Assert.assertTrue(ih.isHappy(7));
        Assert.assertFalse(ih.isHappy(8));
        Assert.assertFalse(ih.isHappy(9));
        Assert.assertTrue(ih.isHappy(10));
        Assert.assertTrue(ih.isHappy(19));
    }
}
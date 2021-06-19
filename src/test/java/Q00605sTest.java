import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00605sTest {

    Q00605s q00605s = new Q00605s();

    @Test
    public void canPlaceFlowers() {
        Assert.assertTrue(q00605s.canPlaceFlowers(new int[]{0, 0, 0}, 2));
        Assert.assertTrue(q00605s.canPlaceFlowers(new int[]{0}, 1));
        Assert.assertTrue(q00605s.canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
        int[] flowerbed = {1, 0, 0, 0, 1};
        Assert.assertFalse(q00605s.canPlaceFlowers(flowerbed, 2));
        Assert.assertTrue(q00605s.canPlaceFlowers(flowerbed, 1));
    }
}
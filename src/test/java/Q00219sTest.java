import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00219sTest {

    Q00219s q00219s = new Q00219s();

    @Test
    public void containsNearbyDuplicate() {
        Assert.assertTrue(q00219s.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assert.assertFalse(q00219s.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 2));
        Assert.assertTrue(q00219s.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assert.assertFalse(q00219s.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
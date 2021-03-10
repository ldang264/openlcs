import org.junit.Assert;
import org.junit.Test;

public class Q00035sTest {

    Q00035s q00035s = new Q00035s();

    @Test
    public void searchInsert() {
        Assert.assertEquals(q00035s.searchInsert(new int[]{1, 3, 5, 6}, 7), 4); // 4
        Assert.assertEquals(q00035s.searchInsert(new int[]{1, 3}, 2), 1); // 1
        Assert.assertEquals(q00035s.searchInsert(new int[]{1, 3, 5, 6}, 5), 2); // 2
        Assert.assertEquals(q00035s.searchInsert(new int[]{1, 3, 5, 6}, 0), 0); // 0
        Assert.assertEquals(q00035s.searchInsert(new int[]{1, 3, 5, 6}, 2), 1); // 1
    }
}
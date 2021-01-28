import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00062mTest {

    Q00062m q00062m = new Q00062m();

    @Test
    public void uniquePaths() {
        Assert.assertEquals(28, q00062m.uniquePaths(3, 7));
        Assert.assertEquals(3, q00062m.uniquePaths(3, 2));
        Assert.assertEquals(28, q00062m.uniquePaths(7, 3));
        Assert.assertEquals(6, q00062m.uniquePaths(3, 3));
    }
}
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00443mTest {

    Q00443m q00443m = new Q00443m();

    @Test
    public void compress() {
        char[] cs1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        Assert.assertEquals(q00443m.compress(cs1), 6);
        Assert.assertArrayEquals(cs1, new char[]{'a', '2', 'b', '2', 'c', '3', 'c'});
    }
}
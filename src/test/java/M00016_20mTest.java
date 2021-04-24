import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00016_20mTest {

    M00016_20m m00016_20m = new M00016_20m();

    @Test
    public void getValidT9Words() {
        Assert.assertEquals(m00016_20m.getValidT9Words("8733", new String[]{"tree", "used"}).toString(), "[tree, used]");
        Assert.assertEquals(m00016_20m.getValidT9Words("2", new String[]{"a", "b", "c", "d"}).toString(), "[a, b, c]");
    }
}
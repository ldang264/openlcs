import org.junit.Assert;
import org.junit.Test;

public class Q00274mTest {

    Q00274m_Ans q00274m = new Q00274m_Ans();

    @Test
    public void hIndex() {
        Assert.assertEquals(q00274m.hIndex(new int[]{1, 2}), 1);
        Assert.assertEquals(q00274m.hIndex(new int[]{0}), 0);
        Assert.assertEquals(q00274m.hIndex(new int[]{100}), 1);
        Assert.assertEquals(q00274m.hIndex(new int[]{3, 0, 6, 1, 5}), 3);
        Assert.assertEquals(q00274m.hIndex(new int[]{1, 3, 1}), 1);
    }
}
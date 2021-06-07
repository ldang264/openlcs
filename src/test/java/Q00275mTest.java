import org.junit.Assert;
import org.junit.Test;

public class Q00275mTest {

    Q00275m_Ans q00275m = new Q00275m_Ans();

    @Test
    public void hIndex() {
        Assert.assertEquals(q00275m.hIndex(new int[]{0,1,3,5,6}), 3);
    }
}
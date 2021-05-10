import org.junit.Assert;
import org.junit.Test;

public class M00008_11mTest {

    M00008_11m_Ans m00008_11m = new M00008_11m_Ans();

    @Test
    public void waysToChange() {
        Assert.assertEquals(m00008_11m.waysToChange(10), 4);
    }
}
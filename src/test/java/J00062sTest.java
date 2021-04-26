import org.junit.Assert;
import org.junit.Test;

public class J00062sTest {

    J00062s_Ans j00062s = new J00062s_Ans();

    @Test
    public void lastRemaining() {
        Assert.assertEquals(j00062s.lastRemaining(5, 3), 3);
        Assert.assertEquals(j00062s.lastRemaining(10, 17), 2);
    }
}
import org.junit.Assert;
import org.junit.Test;

public class Q00050m_QuickMulTest {

    private static Q00050m_QuickMul qm = new Q00050m_QuickMul();

    @Test
    public void myPow1() {
        Assert.assertEquals(1024.00000, qm.myPow(2.00000, 10), 0);
    }
}
import org.junit.Assert;
import org.junit.Test;

public class J00033MAnsTest {

    J00033m_Ans j00033MAns = new J00033m_Ans();

    @Test
    public void verifyPostorder() {
        Assert.assertTrue(j00033MAns.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        Assert.assertFalse(j00033MAns.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }
}
import ans.Q00416m_Ans;
import org.junit.Assert;
import org.junit.Test;

public class Q00416MAnsTest {

    Q00416m_Ans q00416MAns = new Q00416m_Ans();

    @Test
    public void canPartition() {
        Assert.assertTrue(q00416MAns.canPartition(new int[]{14, 9, 8, 4, 3, 2}));
        Assert.assertTrue(q00416MAns.canPartition(new int[]{1, 3, 5, 7}));
        Assert.assertTrue(q00416MAns.canPartition(new int[]{7, 3, 5, 1}));
        Assert.assertTrue(q00416MAns.canPartition(new int[]{1, 5, 11, 5}));
        Assert.assertFalse(q00416MAns.canPartition(new int[]{1, 2, 3, 5}));
        Assert.assertFalse(q00416MAns.canPartition(new int[]{1, 2, 3, 8}));
    }
}
import ans.Q00377m_Ans;
import org.junit.Assert;
import org.junit.Test;

public class Q00377m_AnsTest {

    Q00377m_Ans q00377m = new Q00377m_Ans();

    @Test
    public void combinationSum4() {
        Assert.assertEquals(q00377m.combinationSum4(new int[]{1,2,3}, 4), 7);
    }
}
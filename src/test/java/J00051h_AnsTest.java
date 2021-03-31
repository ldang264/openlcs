import ans.J00051h_Ans;
import org.junit.Assert;
import org.junit.Test;

public class J00051h_AnsTest {

    J00051h_Ans j00051h_ans = new J00051h_Ans();

    @Test
    public void reversePairs() {
        Assert.assertEquals(j00051h_ans.reversePairs(new int[]{7,5,6,4}), 5);
    }

    @Test
    public void reversePairs2() {
        Assert.assertEquals(j00051h_ans.reversePairs(new int[]{13,5,9,2}), 5);
    }
}
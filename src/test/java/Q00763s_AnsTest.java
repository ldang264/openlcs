import ans.Q00763s_Ans;
import org.junit.Assert;
import org.junit.Test;

public class Q00763s_AnsTest {

    Q00763s_Ans pl = new Q00763s_Ans();

    @Test
    public void partitionLabels() {
        Assert.assertEquals("[9, 7, 8]", pl.partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}
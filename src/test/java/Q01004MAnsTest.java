import org.junit.Assert;
import org.junit.Test;

public class Q01004MAnsTest {

    Q01004m_Ans q01004MAns = new Q01004m_Ans();

    @Test
    public void longestOnes() {
        Assert.assertEquals(6, q01004MAns.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        Assert.assertEquals(10, q01004MAns.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
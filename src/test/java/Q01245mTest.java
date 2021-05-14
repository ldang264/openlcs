import org.junit.Assert;
import org.junit.Test;

public class Q01245mTest {

    Q01245m_Ans q01245m = new Q01245m_Ans();

    @Test
    public void treeDiameter() {
        Assert.assertEquals(2, q01245m.treeDiameter(new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        Assert.assertEquals(2, q01245m.treeDiameter(new int[][]{{0, 1}, {0, 2}}));
        Assert.assertEquals(4, q01245m.treeDiameter(new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}}));
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class M00008_12hTest {

    M00008_12h m00008_12h = new M00008_12h();

    @Test
    public void solveNQueens() {
        List<List<String>> ans = m00008_12h.solveNQueens(4);
        Assert.assertEquals(ans.toString(), "[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]");
    }
}
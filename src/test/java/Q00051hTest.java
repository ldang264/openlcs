import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00051hTest {

    Q00051h q00051h = new Q00051h();

    @Test
    public void solveNQueens() {
        Assert.assertEquals(q00051h.solveNQueens(1).toString(), "[[Q]]");
        Assert.assertEquals(q00051h.solveNQueens(2).toString(), "[]");
        Assert.assertEquals(q00051h.solveNQueens(3).toString(), "[]");
        Assert.assertEquals(q00051h.solveNQueens(4).toString(), "[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]");
    }
}
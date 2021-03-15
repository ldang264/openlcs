import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00052hTest {

    Q00052h q00052h = new Q00052h();

    @Test
    public void totalNQueens() {
        Assert.assertEquals(q00052h.totalNQueens(1), 1);
        Assert.assertEquals(q00052h.totalNQueens(2), 0);
        Assert.assertEquals(q00052h.totalNQueens(3), 0);
        Assert.assertEquals(q00052h.totalNQueens(4), 2);

    }
}
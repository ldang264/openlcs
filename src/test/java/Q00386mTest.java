import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00386mTest {

    Q00386m q00386m = new Q00386m();

    @Test
    public void lexicalOrder() {
        Assert.assertEquals(q00386m.lexicalOrderDfs(13).toString(), "[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]");
        Assert.assertEquals(q00386m.lexicalOrderCompute(13).toString(), "[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]");
    }
}
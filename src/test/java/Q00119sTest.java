import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00119sTest {

    Q00119s q00119s = new Q00119s();

    @Test
    public void getRow() {
        Assert.assertEquals("[1, 2, 1]", q00119s.getRow(2).toString());
        Assert.assertEquals("[1, 3, 3, 1]", q00119s.getRow(3).toString());
        Assert.assertEquals("[1, 4, 6, 4, 1]", q00119s.getRow(4).toString());
    }
}
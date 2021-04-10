import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00067sTest {

    Q00067s q00067s = new Q00067s();

    @Test
    public void addBinary() {
        Assert.assertEquals(q00067s.addBinary("11", "1"), "100");
        q00067s.addBinary(q00067s.addBinary("1010", "1011"), "10101");
        q00067s.addBinary(q00067s.addBinary("0", "1"), "1");
    }
}
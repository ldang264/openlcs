import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00190sTest {

    Q00190s q00190s = new Q00190s();

    @Test
    public void reverseBits() {
        Assert.assertEquals(q00190s.reverseBits(43261596), 964176192);
    }
}
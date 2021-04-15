import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00187mTest {

    Q00187m q00187m = new Q00187m();

    @Test
    public void findRepeatedDnaSequences() {
        Assert.assertEquals(q00187m.findRepeatedDnaSequences("AAAAAGGGGGAAAAAGGGGGGAAAAACCCCTTT").toString(), "[GGGGGAAAAA, AAAAAGGGGG]");
        Assert.assertEquals(q00187m.findRepeatedDnaSequences("AAAAAAAAAAA").toString(), "[AAAAAAAAAA]");
        Assert.assertEquals(q00187m.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString(), "[AAAAACCCCC, CCCCCAAAAA]");
    }
}
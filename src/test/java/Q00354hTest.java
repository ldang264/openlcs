import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00354hTest {

    Q00354h q00354h = new Q00354h();

    @Test
    public void maxEnvelopes() {
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Assert.assertEquals(q00354h.maxEnvelopes(envelopes), 3);
    }

    @Test
    public void maxEnvelopes1() {
        int[][] envelopes = new int[][]{{1,44},{5,8},{7,23},{27,0}, {32,36}};
        Assert.assertEquals(q00354h.maxEnvelopes(envelopes), 3);
    }
}
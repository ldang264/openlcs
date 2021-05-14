import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00149hTest {

    Q00149h q00149h = new Q00149h();

    @Test
    public void maxPoints() {
        Assert.assertEquals(q00149h.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}), 4);
        Assert.assertEquals(q00149h.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}), 3);
    }
}
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00041hTest {

    @Test
    public void addNum() {
        J00041h q00295h = new J00041h();
        // 6
        q00295h.addNum(6);
        Assert.assertEquals(q00295h.findMedian(), 6.0, 0.1);
        q00295h.addNum(10);
        // 6 10
        Assert.assertEquals(q00295h.findMedian(), 8, 0.1);
        q00295h.addNum(2);
        // 2 6 10
        Assert.assertEquals(q00295h.findMedian(), 6, 0.1);
        q00295h.addNum(6);
        // 2 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 6, 0.1);
        q00295h.addNum(5);
        // 2 5 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 6, 0.1);
        q00295h.addNum(0);
        // 0 2 5 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 5.5, 0.1);
        q00295h.addNum(6);
        // 0 2 5 6 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 6, 0.1);
        q00295h.addNum(3);
        // 0 2 3 5 6 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 5.5, 0.1);
        q00295h.addNum(1);
        // 0 1 2 3 5 6 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 5, 0.1);
        q00295h.addNum(0);
        // 0 0 1 2 3 5 6 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 4, 0.1);
        q00295h.addNum(0);
        // 0 0 0 1 2 3 5 6 6 6 10
        Assert.assertEquals(q00295h.findMedian(), 3, 0.1);
    }
}
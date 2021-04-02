import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00622mTest {

    @Test
    public void test() {
        Q00622m circularQueue = new Q00622m(3); // 设置长度为 3
        Assert.assertTrue(circularQueue.enQueue(1)); // 返回 true
        Assert.assertTrue(circularQueue.enQueue(2)); // 返回 true
        Assert.assertTrue(circularQueue.enQueue(3)); // 返回 true
        Assert.assertFalse(circularQueue.enQueue(4)); // 返回 false，队列已满
        Assert.assertEquals(circularQueue.Rear(), 3); // 返回 3
        Assert.assertTrue(circularQueue.isFull()); // 返回 true
        Assert.assertTrue(circularQueue.deQueue()); // 返回 true
        Assert.assertTrue(circularQueue.enQueue(4)); // 返回 true
        Assert.assertTrue(circularQueue.isFull()); // 返回 true
        Assert.assertEquals(circularQueue.Rear(), 4); // 返回 4
        Assert.assertEquals(circularQueue.Front(), 2); // 返回 2
        Assert.assertTrue(circularQueue.deQueue()); // 返回 true
        Assert.assertEquals(circularQueue.Front(), 3); // 返回 3
        Assert.assertTrue(circularQueue.deQueue()); // 返回 true
        Assert.assertEquals(circularQueue.Front(), 4); // 返回 4
        Assert.assertTrue(circularQueue.deQueue()); // 返回 true
        Assert.assertFalse(circularQueue.isFull()); // 返回 false
        Assert.assertTrue(circularQueue.isEmpty()); // 返回 true
    }

}
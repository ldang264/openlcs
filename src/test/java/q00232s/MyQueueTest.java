package q00232s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        int i = myQueue.peek();
        Assert.assertEquals(1, i);
        i = myQueue.pop();
        Assert.assertEquals(1, i);
        i = myQueue.pop();
        Assert.assertEquals(2, i);
        i = myQueue.pop();
        Assert.assertEquals(3, i);
        i = myQueue.pop();
        Assert.assertEquals(4, i);
        boolean j = myQueue.empty();
        Assert.assertTrue(j);
    }

}
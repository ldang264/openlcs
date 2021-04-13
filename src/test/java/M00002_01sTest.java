import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class M00002_01sTest {

    M00002_01s m00002_01s = new M00002_01s();

    @Test
    public void removeDuplicateNodes() {
        Assert.assertEquals(String.valueOf(m00002_01s.removeDuplicateNodes(ListNode.deserialize("1, 2, 3, 3, 2, 1"))), "1,2,3");
        Assert.assertEquals(String.valueOf(m00002_01s.removeDuplicateNodes(ListNode.deserialize("1, 1, 1, 1, 2"))), "1,2");
        Assert.assertEquals(String.valueOf(m00002_01s.removeDuplicateNodes(ListNode.deserialize("1, 1, 1, 1"))), "1");
        Assert.assertEquals(String.valueOf(m00002_01s.removeDuplicateNodes(ListNode.deserialize("1, 1"))), "1");
        Assert.assertEquals(String.valueOf(m00002_01s.removeDuplicateNodes(ListNode.deserialize("1"))), "1");
    }
}
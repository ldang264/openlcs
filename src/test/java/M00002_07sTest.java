import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class M00002_07sTest {

    M00002_07s m00002_07s = new M00002_07s();

    @Test
    public void getIntersectionNode1() {
        ListNode node = ListNode.deserialize("1, 2");
        Assert.assertNull(m00002_07s.getIntersectionNode(node, ListNode.deserialize("1, 2, 3")));
        Assert.assertEquals(node.next, m00002_07s.getIntersectionNode(node, node.next));
        Assert.assertNull(m00002_07s.getIntersectionNode(ListNode.deserialize("1, 2"), null));
    }
}
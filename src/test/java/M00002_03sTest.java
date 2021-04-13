import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class M00002_03sTest {

    M00002_03s m00002_03s = new M00002_03s();

    @Test
    public void deleteNode() {
        ListNode head = ListNode.deserialize("1,2,3,4,5");
        m00002_03s.deleteNode(head.next);
        Assert.assertEquals(head.toString(), "1,3,4,5");
    }
}
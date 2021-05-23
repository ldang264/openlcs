import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class Q00143mTest {

    Q00143m q00143m = new Q00143m();

    @Test
    public void reorderList() {
        ListNode head = ListNode.deserialize("1,2,3,4");
        q00143m.reorderList(head);
        Assert.assertEquals(head.toString(), "[1,4,2,3]");
    }

    @Test
    public void reorderList1() {
        ListNode head = ListNode.deserialize("1,2,3,4,5");
        q00143m.reorderList(head);
        Assert.assertEquals(head.toString(), "[1,5,2,4,3]");
    }
}
import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class J00052sTest {

    J00052s j00052s = new J00052s();

    @Test
    public void getIntersectionNode1() {
        ListNode jd = ListNode.deserialize("8, 4, 5");
        ListNode a = ListNode.deserialize("4, 1");
        a.next.next = jd;
        ListNode b = ListNode.deserialize("5, 0, 1");
        b.next.next.next = jd;
        Assert.assertEquals(j00052s.getIntersectionNode(a, b), jd);
    }

    @Test
    public void getIntersectionNode2() {
        ListNode jd = ListNode.deserialize("2, 4");
        ListNode a = ListNode.deserialize("0, 9, 1");
        a.next.next.next = jd;
        ListNode b = ListNode.deserialize("3");
        b.next = jd;
        Assert.assertEquals(j00052s.getIntersectionNode(a, b), jd);
    }

    @Test
    public void getIntersectionNode3() {
        ListNode a = ListNode.deserialize("1, 5");
        ListNode b = ListNode.deserialize("2, 6, 4");
        Assert.assertNull(j00052s.getIntersectionNode(a, b));
    }

    @Test
    public void getIntersectionNode4() {
        ListNode a = ListNode.deserialize("1, 5");
        ListNode b = ListNode.deserialize("3");
        b.next = a;
        Assert.assertEquals(j00052s.getIntersectionNode(a, b), a);
    }

    @Test
    public void getIntersectionNode5() {
        ListNode b = ListNode.deserialize("1");
        Assert.assertNull(j00052s.getIntersectionNode(null, b));
    }

}
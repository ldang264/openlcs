import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00725mTest {

    Q00725m q00725m = new Q00725m();

    @Test
    public void splitListToParts() {
        ListNode l1 = new ListNode(1);
        Assert.assertArrayEquals(new ListNode[]{l1}, q00725m.splitListToParts(l1, 1));
        ListNode l2 = new ListNode(1);
        Assert.assertArrayEquals(new ListNode[]{l2, null}, q00725m.splitListToParts(l2, 2));
        Assert.assertArrayEquals(new ListNode[1], q00725m.splitListToParts(null, 1));
        Assert.assertArrayEquals(new ListNode[2], q00725m.splitListToParts(null, 2));
    }

    @Test
    public void splitListToParts1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assert.assertArrayEquals(new ListNode[]{l1, l2, l3, l4, null}, q00725m.splitListToParts(l1, 5));
    }

    @Test
    public void splitListToParts2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assert.assertArrayEquals(new ListNode[]{l1}, q00725m.splitListToParts(l1, 1));
    }

    @Test
    public void splitListToParts3() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assert.assertArrayEquals(new ListNode[]{l1, l3}, q00725m.splitListToParts(l1, 2));
    }

    @Test
    public void splitListToParts4() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assert.assertArrayEquals(new ListNode[]{l1, l3, l4}, q00725m.splitListToParts(l1, 3));
    }

    @Test
    public void splitListToParts5() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assert.assertArrayEquals(new ListNode[]{l1, l2, l3, l4}, q00725m.splitListToParts(l1, 4));
    }
}
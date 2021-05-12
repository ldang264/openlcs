import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class Q01669mTest {

    Q01669m q01669m = new Q01669m();

    @Test
    public void mergeInBetween1() {
        ListNode list1 = ListNode.deserialize("[0,1,2,3,4,5]");
        ListNode list2 = ListNode.deserialize("[1000000,1000001,1000002]");
        ListNode listNode = q01669m.mergeInBetween(list1, 3, 4, list2);
        Assert.assertEquals(listNode.toString(), "[0,1,2,1000000,1000001,1000002,5]");
    }

    @Test
    public void mergeInBetween2() {
        ListNode list1 = ListNode.deserialize("[0,1,2,3,4,5,6]");
        ListNode list2 = ListNode.deserialize("[1000000,1000001,1000002,1000003,1000004]");
        ListNode listNode = q01669m.mergeInBetween(list1, 2, 5, list2);
        Assert.assertEquals(listNode.toString(), "[0,1,1000000,1000001,1000002,1000003,1000004,6]");
    }

    @Test
    public void mergeInBetween3() {
        ListNode list1 = ListNode.deserialize("[0,1,2,3,4,5]");
        ListNode list2 = ListNode.deserialize("[1000000,1000001,1000002]");
        ListNode listNode = q01669m.mergeInBetween(list1, 3, 3, list2);
        Assert.assertEquals(listNode.toString(), "[0,1,2,1000000,1000001,1000002,4,5]");
    }

}
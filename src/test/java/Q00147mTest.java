import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00147mTest {

    Q00147m q00147m = new Q00147m();

    @Test
    public void insertionSortList() {
        Assert.assertEquals("[1,2,3,4]", q00147m.insertionSortList(ListNode.deserialize("[4,2,1,3]")).toString());
        Assert.assertEquals("[-1,0,3,4,5]", q00147m.insertionSortList(ListNode.deserialize("[-1,5,3,4,0]")).toString());
    }
}
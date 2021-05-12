import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00082mTest {

    Q00082m q00082m = new Q00082m();

    @Test
    public void deleteDuplicates() {
        Assert.assertEquals("[1,2,5]", q00082m.deleteDuplicates(ListNode.deserialize("[1,2,3,3,4,4,5]")).toString());
        Assert.assertEquals("[2,3]", q00082m.deleteDuplicates(ListNode.deserialize("[1,1,1,2,3]")).toString());
        Assert.assertEquals("[1]", q00082m.deleteDuplicates(ListNode.deserialize("[1,2,2]")).toString());
        Assert.assertNull(q00082m.deleteDuplicates(ListNode.deserialize("[1,1,2,2]")));
    }
}
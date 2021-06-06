import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00234sTest {

    Q00234s q00234s = new Q00234s();

    @Test
    public void isPalindrome() {
        Assert.assertTrue(q00234s.isPalindrome(ListNode.deserialize("[1]")));
        Assert.assertTrue(q00234s.isPalindrome(ListNode.deserialize("[1,1]")));
        Assert.assertTrue(q00234s.isPalindrome(ListNode.deserialize("[1,2,1]")));
        Assert.assertTrue(q00234s.isPalindrome(ListNode.deserialize("[1,2,2,1]")));
    }
}
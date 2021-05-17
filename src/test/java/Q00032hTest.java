import org.junit.Assert;
import org.junit.Test;

public class Q00032hTest {
    
    Q00032h q00032h = new Q00032h();

    @Test
    public void longestValidParentheses() {
        Assert.assertEquals(q00032h.longestValidParentheses("(()"), 2); // 2
        Assert.assertEquals(q00032h.longestValidParentheses(")()())"), 4); // 4
        Assert.assertEquals(q00032h.longestValidParentheses("()(())"), 6); // 6
        Assert.assertEquals(q00032h.longestValidParentheses("()(()"), 2); // 2
        Assert.assertEquals(q00032h.longestValidParentheses(")()())"), 4); // 4
        Assert.assertEquals(q00032h.longestValidParentheses(")()())()()("), 4); // 4
    }

    @Test
    public void longestValidParenthesesDp() {
        Assert.assertEquals(q00032h.longestValidParenthesesDp("(()"), 2); // 2
        Assert.assertEquals(q00032h.longestValidParenthesesDp(")()())"), 4); // 4
        Assert.assertEquals(q00032h.longestValidParenthesesDp("()(())"), 6); // 6
        Assert.assertEquals(q00032h.longestValidParenthesesDp("()(()"), 2); // 2
        Assert.assertEquals(q00032h.longestValidParenthesesDp(")()())"), 4); // 4
        Assert.assertEquals(q00032h.longestValidParenthesesDp(")()())()()("), 4); // 4
    }
}
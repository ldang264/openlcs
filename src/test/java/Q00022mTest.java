import org.junit.Assert;
import org.junit.Test;

public class Q00022mTest {

    private Q00022m gp = new Q00022m();

    @Test
    public void generateParenthesis() {
        Assert.assertEquals(5, gp.generateParenthesis(3).size());
    }

    @Test
    public void generateParenthesis1() {
        Assert.assertEquals(14, gp.generateParenthesis(4).size());
    }

    @Test
    public void generateParenthesis2() {
        Assert.assertEquals(42, gp.generateParenthesis(5).size());
    }
}

//["((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"]
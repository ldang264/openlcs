package q00022m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {

    private GenerateParenthesis gp = new GenerateParenthesis();

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
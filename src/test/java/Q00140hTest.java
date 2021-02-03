import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Q00140hTest {

    private Q00140h wb = new Q00140h();

    @Test
    public void wordBreak1() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> ans = wb.wordBreak(s, wordDict);
        Assert.assertEquals("[cat sand dog, cats and dog]", ans.toString());
    }

    @Test
    public void wordBreak2() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> ans = wb.wordBreak(s, wordDict);
        Assert.assertEquals("[pine apple pen apple, pine applepen apple, pineapple pen apple]", ans.toString());
    }

    @Test
    public void wordBreak3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> ans = wb.wordBreak(s, wordDict);
        Assert.assertEquals("[]", ans.toString());
    }

    @Test
    public void wordBreak4() {
        String s = "aaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
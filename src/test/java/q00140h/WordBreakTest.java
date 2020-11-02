package q00140h;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {

    private WordBreak wb = new WordBreak();

    @Test
    public void wordBreak1() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
        // "cats and dog"
        // "cat sand dog"
    }

    @Test
    public void wordBreak2() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
        // "pine apple pen apple",
        // "pineapple pen apple",
        // "pine applepen apple"
    }

    @Test
    public void wordBreak3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    @Test
    public void wordBreak4() {
        String s = "aaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
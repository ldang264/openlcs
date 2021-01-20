import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 会超时，垃圾
 */
public class Q00140h {
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (int i = wordDict.size() - 1; i >= 0; i--) {
            if (s.indexOf(wordDict.get(i)) == -1) {
                wordDict.remove(i);
            }
        }
        List<String> ans = new ArrayList<>();
        loop(s, "", wordDict, ans);
        return ans;
    }

    private void loop(String subStr, String preStr, List<String> wordDict, List<String> ans) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (subStr.equals(wordDict.get(i))) {
                ans.add(/*preStr.isEmpty() ? subStr : */preStr + " " + subStr);
            } else if (subStr.startsWith(wordDict.get(i))) {
                loop(subStr.substring(wordDict.get(i).length()), /*preStr.isEmpty() ? wordDict.get(i) : */preStr + " " + wordDict.get(i), wordDict, ans);
            }
        }
    }
}

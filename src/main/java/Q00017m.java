import java.util.*;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00017m {

    /**
     * 动态规划
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, List<String>> characterMap = new HashMap<>();
        characterMap.put('2', Arrays.asList("a", "b", "c"));
        characterMap.put('3', Arrays.asList("d", "e", "f"));
        characterMap.put('4', Arrays.asList("g", "h", "i"));
        characterMap.put('5', Arrays.asList("j", "k", "l"));
        characterMap.put('6', Arrays.asList("m", "n", "o"));
        characterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        characterMap.put('8', Arrays.asList("t", "u", "v"));
        characterMap.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String>[] dp = new List[digits.length()];
        dp[0] = characterMap.get(digits.charAt(0));
        for (int i = 1; i < digits.length(); i++) {
            dp[i] = new ArrayList<>();
            List<String> ics = characterMap.get(digits.charAt(i));
            for (String s : dp[i - 1]) {
                for (String ic : ics) {
                    dp[i].add(s + ic);
                }
            }
        }
        return dp[digits.length() - 1];
    }
}

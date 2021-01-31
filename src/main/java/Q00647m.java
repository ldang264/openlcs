import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00647m {
    public int countSubstrings(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int ans = s.length();
        List<Integer>[] dp = new List[s.length()]; // dp[i]是每个i+1长度回文子串的起点下标值
        List<Integer> list0 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list0.add(i); // 1个字符都是回文
        }
        dp[0] = list0;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) { // 2个字符是前后相等
                list1.add(i);
                ans++;
            }
        }
        dp[1] = list1;
        for (int i = 2; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
            // dp[i]是dp[i - 2]且其左边字符等于右边字符的情况
            for (Integer j : dp[i - 2]) {
                int k = j - 1;
                if (k >= 0 && k + i < s.length() && s.charAt(k) == s.charAt(k + i)) {
                    dp[i].add(k);
                    ans++;
                }
            }
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00131m {

    private String str;

    private int len;

    private List<List<String>> ans;

    private List<String> help;

    public List<List<String>> partition(String s) {
        str = s;
        len = s.length();
        ans = new ArrayList<>();
        help = new ArrayList<>();
        // dp[i][j]表示对s(i)到s(j)的判断，true是回文，false不是
        boolean[][] dp = new boolean[len][len];
        dp[len - 1][len - 1] = true;
        // 自底向上填充dp
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = true;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        // 对dp进行回溯
        for (int i = 0; i < len; i++) {
            dfs(dp, 0, i);
        }
        return ans;
    }

    private void dfs(boolean[][] dp, int i, int j) {
        if (dp[i][j]) { // 如果i-j是回文，则下一次从j+1开始，一直判断到字符串结束
            j++;
            help.add(str.substring(i, j));
            if (j == len) { // 到达字符串结束都是回文
                ans.add(new ArrayList<>(help));
            } else {
                for (int k = j; k < len; k++) {
                    dfs(dp, j, k);
                }
            }
            help.remove(help.size() - 1);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00005m {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String ans = "";
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        // 遍历一次，找到前后两个相等或者隔一个相等的
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2)){
                oddList.add(i + 1);
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                evenList.add(i);
            }
        }
        if (s.charAt(s.length() - 2) == s.charAt(s.length() - 1)) { // 因为偶数的只算到倒数第三个，所以最后要判断
            evenList.add(s.length() - 2);
        }
        for (Integer index : oddList) {
            ans = find(s, ans, index, index - 2);
        }
        for (Integer index : evenList) {
            ans = find(s, ans, index, index - 1);
        }
        return ans.length() > 0 ? ans : s.substring(0, 1);
    }

    /**
     *
     * @param s 原字符串
     * @param ans 结果字符串
     * @param index 奇数列表是中间的字符位置；偶数列表是起始字符的位置
     * @param i 列表的左界-1
     * @return
     */
    private String find(String s, String ans, int index, int i) {
        int j = index + 2; // 奇数列表中三个字符的右界+1；偶数列表中两个字符的右界+1
        String temp = null;
        while (i >= 0 && j <= s.length() - 1) { // i向左，j向右
            if (s.charAt(i) != s.charAt(j)) {
                temp = s.substring(i + 1, j);
                break;
            }
            i--;
            j++;
        }
        if (temp == null) temp = s.substring(i + 1, j);
        if (temp.length() > ans.length()) {
            ans = temp;
        }
        return ans;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s.length() == 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[s.length() - 1][s.length() - 1] = true;
        for (int i = s.length() - 2; i >= 0; i--) { // 从下往上更新
            dp[i][i] = true; // 一个字符肯定是true
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1); // 两个字符判断相等
            for (int j = i + 2; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j); // 其他情况，判断子状态和两头字符
            }
        }
        int r = 0, c = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    int dist = j + 1 - i;
                    if (dist > maxLen) { // 不断更新长度
                        maxLen = dist;
                        r = i;
                        c = j;
                    }
                }
            }
        }
        return s.substring(r, c + 1);
    }
}

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
        if (s == null || s.length() == 0) return 0;
        int ans = s.length();
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length() - j; i++) {
                if (is(s, i, i + j)) ans++;
            }
        }
        return ans;
    }

    private boolean is(String s, int start, int end) {
        while (end > start) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 给你一个回文字符串palindrome ，请你将其中一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且不是回文串。
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 *
 * 示例 1：
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 *
 * 示例 2：
 * 输入：palindrome = "a"
 * 输出：""
 *
 * 提示：
 * 1 <= palindrome.length <= 1000
 * palindrome只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/break-a-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01328m {
    // 012 0123
    // 0   01
    public String breakPalindrome(String palindrome) {
        char[] cs = palindrome.toCharArray();
        for (int i = 0; i < cs.length >> 1; i++) {
            if (cs[i] != 'a') { // 在前半部分，如果有不是a的字符，则换成a
                cs[i] = 'a';
                return new String(cs);
            }
        }
        for (int i = cs.length - 1; i > (cs.length - 1) >> 1; i--) {
            if (cs[i] == 'a') { // 前半部分都是a，则替换最后一个字符为b
                cs[i] = 'b';
                return new String(cs);
            }
        }
        return "";
    }
}

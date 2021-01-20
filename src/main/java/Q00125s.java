/**
 *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00125s {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        int lo = 0;
        int hi = s.length() - 1;
        while (hi > lo) {
            char l = Character.toLowerCase(s.charAt(lo));
            char h = Character.toLowerCase(s.charAt(hi));
            if (!('a' <= l && l <= 'z') && !('0' <= l && l <= '9')) { // 非数字和字母，往高位进一个字符
                lo++;
                continue;
            }
            if (!('a' <= h && h <= 'z') && !('0' <= h && h <= '9')) { // 非数字和字母，往低位退一个字符
                hi--;
                continue;
            }
            if (l != h) return false; // 待比较的字符一旦不等，则立即返回false
            else {
                lo++;
                hi--;
            }
        }
        return true; // 正常比较完成，是回文，返回true
    }
}

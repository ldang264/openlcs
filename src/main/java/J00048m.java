import java.util.Arrays;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 提示：
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00048m {
    public int lengthOfLongestSubstring(String s) {
        int[] cs = new int[128];
        Arrays.fill(cs, -1); // 不可达的下标
        int ans = 0, right = 0, left = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (cs[c] >= left) {
                ans = Math.max(ans, right - left);
                left = cs[c] + 1;
            }
            cs[c] = right++;
        }
        return Math.max(ans, right - left);
    }
}

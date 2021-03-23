import java.util.HashMap;
import java.util.Map;

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
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> indexMap = new HashMap<>();
        int ans = 0, start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = indexMap.put(c, i); // 返回旧的下标
            if (index != null && index > start) { // 如果已经存在该字符，且该字符大于查找位置，则跳到当前位置
                start = index;
            } else {
                ans = Math.max(ans, i - start); // 不存在或者过了当前位置，计算一次
            }
        }
        return ans;
    }
}

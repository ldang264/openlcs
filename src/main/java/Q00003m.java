import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
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
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00003m {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int[] cs = new int[128];
        Arrays.fill(cs, -1); // 初始化为不存在的下标
        int ans = 0, last = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cs[c] >= last) { // 存在，计算一次，并清除
                ans = Math.max(ans, i - last);
                last = cs[c] + 1;
            }
            cs[c] = i;
        }
        return Math.max(ans, s.length() - last);
    }


    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int ans = 1, start = 0 /*当前查找的起点*/, i = 1 /* 当前字符位置 */;
        while (i < s.length()) {
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) { // 如果其中有一个与当前字符相等
                    ans = Math.max(ans, i - start); // 说明start到i-1是一个候选子串
                    start = j + 1; // 窗口移到第一个重复的下一个
                    break;
                }
            }
            i++;
        }
        if (s.charAt(i - 1) != s.charAt(start)) {
            ans = Math.max(ans, i - start);
        }
        return ans;
    }


    /**
     * HashMap存储字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 1, start = 0, i = 1;
        map.put(s.charAt(0), 0);
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) { //
                int index = map.get(s.charAt(i));
                if (index >= start) {
                    ans = Math.max(ans, i - start);
                    start = index + 1;
                }
            }
            map.put(s.charAt(i), i);
            i++;
        }
        if (s.charAt(i - 1) != s.charAt(start)) {
            ans = Math.max(ans, i - start);
        }
        return ans;
    }

}

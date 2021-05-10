/**
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 提示：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00567m {
    public boolean checkInclusion(String s1, String s2) {
        int len1, len2;
        if ((len1 = s1.length()) > (len2 = s2.length())) return false;
        int[] cs = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            cs[s1.charAt(i)]++; // 统计s1出现的字符个数
        }
        int left = 0, right = 0; // 滑动窗口
        while (left <= len2 - len1 && right < len2) {
            char c2 = s2.charAt(right++);
            if (cs[c2] == 0) { // 不够减
                while (left < right && s2.charAt(left) != c2) {
                    cs[s2.charAt(left++)]++; // 把到当前字符的都加回来
                }
                left++;
                continue;
            }
            if (right - left == len1) return true; // 整个区间都够减，则表示匹配
            cs[c2]--; // 减掉当前字符
        }
        return false;
    }
}

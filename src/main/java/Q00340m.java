import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出至多包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 *
 * 示例 2:
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 提示:
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00340m {

    /**
     * 滑动窗口
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0) return 0;
        int ans = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>(); // 键是字符，值是最后出现的下标
        while (right < s.length()) {
            if (map.put(s.charAt(right), right) == null) { // 当前元素一定会加入，返回值是其原下标，为空则表示原来是不存在的
                if (k > 0) { // k还有
                    k--; // 则减少
                } else { // k减为0了，要删除最小的下标的字符
                    for (int i = left; i < right; i++) {
                        if (map.get(s.charAt(i)) == i) { // 因为是从left开始找的，所以一定是最小的
                            map.remove(s.charAt(i));
                            left = i + 1;
                            break;
                        }
                    }
                }
            }
            right++;
            ans = Math.max(ans, right - left); // 每次都计算最大长度
        }
        return ans;
    }
}

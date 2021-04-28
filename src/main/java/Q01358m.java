import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，它只包含三种字符 a, b 和 c 。
 * 请你返回 a，b 和 c 都至少出现过一次的子字符串数目。
 * <p>
 * 示例 1：
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * <p>
 * 示例 2：
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * <p>
 * 示例 3：
 * 输入：s = "abc"
 * 输出：1
 * <p>
 * 提示：
 * 3 <= s.length <= 5 x 10^4
 * s只包含字符 a，b 和 c 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01358m {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), right);
            if (map.size() == 3) {
                ans += s.length() - right;
                map.remove(s.charAt(left), left);
                left++;
            } else {
                right++;
            }
        }
        return ans;
    }

    /**
     * 以索引 i 遍历字符串 s ，考虑子串 (k, i) 满足条件的最大 k，那么此时子串(0, i), ...(k-1, i) 也是符合条件的子串
     * @param s
     * @return
     */
    public int numberOfSubstringsAns(String s) {
        int res = 0;
        // 记录 'a', 'b', 'c' 上次出现的位置
        int[] record = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            // 更新 'a', 'b', 'c' 最近出现的位置
            record[s.charAt(i) - 'a'] = i;
            res += Math.min(record[0], Math.min(record[1], record[2])) + 1;
        }
        return res;
    }
}

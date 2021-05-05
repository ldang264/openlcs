import java.util.HashMap;
import java.util.Map;

/**
 * 段式回文 其实与 一般回文 类似，只不过是最小的单位是 一段字符而不是 单个字母。
 *
 * 举个例子，对于一般回文 "abcba" 是回文，而 "volvo" 不是，但如果我们把"volvo" 分为 "vo"、"l"、"vo" 三段，则可以认为 “(vo)(l)(vo)” 是段式回文（分为 3 段）。
 * 给你一个字符串text，在确保它满足段式回文的前提下，请你返回 段 的最大数量k。
 * 如果段的最大数量为k，那么存在满足以下条件的a_1, a_2, ..., a_k：
 *
 * 每个a_i都是一个非空字符串；
 * 将这些字符串首位相连的结果a_1 + a_2 + ... + a_k和原始字符串text相同；
 * 对于所有1 <= i <= k，都有a_i = a_{k+1 - i}。
 *
 * 示例 1：
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 *
 * 示例 2：
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 *
 * 示例 3：
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 *
 * 示例 4：
 * 输入：text = "aaa"
 * 输出：3
 * 解释：我们可以把字符串拆分成 "(a)(a)(a)"。
 *
 * 提示：
 * text仅由小写英文字符组成。
 * 1 <= text.length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01147h {
    /**
     * 双指针
     * 左指针的字符计数增加，右指针的字符计数减少
     * @param text
     * @return
     */
    public int longestDecomposition(String text) {
        int ans = 0, count = 0, left = 0, right = text.length() - 1;
        int[] helper = new int[128];
        while (left < right) {
            char l = text.charAt(left++);
            char r = text.charAt(right--);
            if (++helper[l] == 0) count--; // 消除了右侧新增的字符
            else if (helper[l] == 1) count++; // 左侧新增了一个字符
            if (--helper[r] == 0) count--; // 消除了左侧新增的字符
            else if (helper[r] == -1) count++; // 右侧新增了一个字符
            if (count == 0) ans += 2; // 数组中所有的字符计数都是0
        }
        return left == right || count > 0 ? ans + 1 : ans; // 奇数或还有未消除的字符，需要+1
    }

    public int longestDecompositionDoublePointer(String text) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(32);
        int left = 0, right = text.length() - 1;
        while (left < right) {
            char l = text.charAt(left++);
            char r = text.charAt(right--);
            if (l != r) {
                Integer lc = map.get(l);
                Integer rc = map.get(r);
                if (lc == null || rc == null) {
                    if (lc == null) {
                        map.put(l, 1);
                    } else if (lc == -1){
                        map.remove(l);
                    } else {
                        map.put(l, lc + 1);
                    }
                    if (rc == null) {
                        map.put(r, -1);
                    } else if (rc == 1){
                        map.remove(r);
                    } else {
                        map.put(r, rc - 1);
                    }
                } else if (lc == -1 && rc == 1) {
                    map.remove(l);
                    map.remove(r);
                    if (map.size() == 0) {
                        ans += 2;
                    }
                } else if (lc == -1) {
                    map.remove(l);
                    map.put(r, rc - 1);
                } else if (rc == 1) {
                    map.put(l, lc + 1);
                    map.remove(r);
                } else {
                    map.put(l, lc + 1);
                    map.put(r, rc - 1);
                }
            } else if (map.size() == 0) {
                ans += 2;
            }
        }
        return left == right || map.size() > 0 ? ans + 1 : ans;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00767m {
    public String reorganizeString(String S) {
        if (S.length() == 1) return S;
        Map<Character, Integer> map = new HashMap<>(); // 键是字符，值是出现的次数
        int maxCount = 0; // 记录字符出现最多的次数
        char maxChar = ' '; // 记录出现最多次数的字符
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = map.merge(c, 1, Integer::sum);
            if (maxCount < count) { // 更新两个max
                maxCount = count;
                maxChar = c;
            }
        }
        int threshold = (S.length() + 1) / 2;
        if (maxCount > threshold) return ""; // 例如，长度为5(aaabb)或6(aaabbb)阈值都是3，最大次数是4(aaaab或aaaabb)就不正确了
        char[] cs = new char[S.length()];
        int index = 0;
        if (maxCount == threshold) { // 如果恰好有等于阈值的，则该字符全部放在奇数位置（下标为偶数）
            map.remove(maxChar);
            while (index < cs.length) {
                cs[index] = maxChar;
                index += 2;
            }
            index = 1; // 放偶数位置（下标为奇数)
        }
        // 挨个取出字符，从偶数位置（下标为奇数)开始放，放完再去奇数位置（下标为偶数）放
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                cs[index] = entry.getKey();
                index += 2;
                if (index >= cs.length) {
                    index = 1;
                }
            }
        }
        return new String(cs);
    }

    /**
     * 参考了答案
     * @param S
     * @return
     */
    public String reorganizeStringAns(String S) {
        if (S.length() == 1) return S;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            maxCount = Math.max(maxCount, map.merge(S.charAt(i), 1, Integer::sum));
        }
        if (maxCount > (S.length() + 1) / 2) return "";
        char[] cs = new char[S.length()];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = S.length() / 2;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count <= halfLength) {
                while (count > 0 && oddIndex < S.length()) {
                    cs[oddIndex] = entry.getKey();
                    count--;
                    oddIndex += 2;
                }
            }
            while (count > 0) {
                cs[evenIndex] = entry.getKey();
                count--;
                evenIndex += 2;
            }
        }
        return new String(cs);
    }
}

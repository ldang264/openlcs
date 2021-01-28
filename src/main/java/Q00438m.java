import java.util.*;

/**
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00438m {
    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || s == null || p.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] cs = new int[26]; // 存放p各个字符计数的数组
        for (int i = 0; i < p.length(); i++) {
            cs[p.charAt(i) - 'a']++;
        }
        int[] temp = new int[26]; // 存放s各个字符计数的数组
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i) - 'a';// s当前字符
            if (cs[sc] == 0) { // 如果在p中不存在
                temp = new int[26]; // 直接初始化temp
                k = i + 1;
            } else if (++temp[sc] > cs[sc]) { // s的当前字符的计数超出了p中该字符的个数
                for (int j = k; j <= i; j++) { // 从上一次扫描的点开始
                    temp[s.charAt(j) - 'a']--;
                    if (s.charAt(j) == s.charAt(i)) { // 一直到减掉第一个字符开始
                        k = j + 1;
                        break;
                    }
                }
            } else if (i - k == p.length() - 1) {
                temp[s.charAt(k) - 'a']--;
                ans.add(k++);
            }
        }
        return ans;
    }
}

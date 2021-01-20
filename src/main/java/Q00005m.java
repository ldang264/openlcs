import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00005m {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String ans = "";
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        // 遍历一次，找到前后两个相等或者隔一个相等的
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2)){
                oddList.add(i + 1);
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                evenList.add(i);
            }
        }
        if (s.charAt(s.length() - 2) == s.charAt(s.length() - 1)) {
            evenList.add(s.length() - 2);
        }
        for (Integer index : oddList) {
            String temp = null;
            int i = index - 2; int j = index + 2;
            while (i >= 0 && j <= s.length() - 1) {
                if (s.charAt(i) != s.charAt(j)) {
                    temp = s.substring(i + 1, j);
                    break;
                } else {
                    i--;
                    j++;
                }
            }
            if (temp == null) temp = s.substring(i + 1, j);
            if (temp.length() > ans.length()) {
                ans = temp;
            }
        }
        for (Integer index : evenList) {
            String temp = null;
            int i = index - 1; int j = index + 2;
            while (i >= 0 && j <= s.length() - 1) {
                if (s.charAt(i) != s.charAt(j)) {
                    temp = s.substring(i + 1, j);
                    break;
                } else {
                    i--;
                    j++;
                }
            }
            if (temp == null) temp = s.substring(i + 1, j);
            if (temp.length() > ans.length()) {
                ans = temp;
            }
        }
        return ans.length() > 0 ? ans : s.substring(0, 1);
        /**
        String ls = "", hs = "";
        int lower = 0, high = s.length() - 1;
         */
    }
    /*
    private void loop(String s, String ls, String hs, int lower, int high) {
        if (high < lower) return;
        if (high == lower && (ls.length() * 2 + 1) > ans.length()) {
            ans = ls + s.charAt(lower) + hs;
            return;
        } else if ((high - lower == 1 && s.charAt(high) == s.charAt(lower)) && (ls.length() + 1) * 2 > ans.length()) {
            ans = ls + s.charAt(lower) + s.charAt(high) + hs;
            return;
        }
        if (s.charAt(lower) == s.charAt(high)) {
            ls = ls + s.charAt(lower);
            hs = s.charAt(high) + hs;
            lower++;
            high--;
        }
    }*/
}

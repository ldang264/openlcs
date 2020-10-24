package q00014s;

/**
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"ab","a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int j = 0;
        try {
            if (strs.length == 1) {
                return strs[0];
            }
            while (j < strs[0].length()) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].charAt(j) != strs[0].charAt(j)) {
                        return exec(strs[0], j);
                    }
                }
                j++;
            }
        } catch (IndexOutOfBoundsException ignored) {
            return exec(strs[0], j);
        }
        return exec(strs[0], j);
    }

    private String exec(String s0, int j) {
        if (j == 0) {
            return "";
        }
        return s0.substring(0, j);
    }
}

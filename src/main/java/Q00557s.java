/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00557s {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        StringBuilder ans = new StringBuilder();
        int start = -1, end = 0; // 不包含它
        while (end < s.length()) {
            if (s.charAt(end) == ' ') { // 空格
                for (int j = end - 1; j > start; j--) {
                    ans.append(s.charAt(j));
                }
                ans.append(' ');
                start = end;
            }
            end++;
        }
        for (int j = end - 1; j > start; j--) { // 最后的全部都翻转
            ans.append(s.charAt(j));
        }
        return ans.toString();
    }
}

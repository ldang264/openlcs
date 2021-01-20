/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00058s {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = s.length() - 1;
        int left = 0;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                left = i + 1; // 找到第一个非空格，left存储剩余长度
                break;
            }
            i--;
        }
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                return left - 1 - i; // 如果在剩余的字符串中找到了空格，则返回该长度差
            }
            i--;
        }
        return left; // 在剩余的字符串都没找到空格，返回left长度
    }
}

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例：
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 注意：
 *
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00186m {
    public void reverseWords(char[] s) {
        int left = 0, right = 0;
        // 1.先一个单词一个单词的翻转
        while (right < s.length) {
            if (s[right] == ' ') {
                // 翻转left到right-1
                int r = right - 1;
                while (left < r) {
                    char c = s[left];
                    s[left] = s[r];
                    s[r] = c;
                    left++;
                    r--;
                }
                left = right + 1;
            }
            right++;
        }
        right--;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
        // 2.整体再翻转一次
        left = 0; right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}

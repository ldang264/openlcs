package q00151;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords(""));
        System.out.println(rw.reverseWords("a"));
        System.out.println(rw.reverseWords(" "));
        System.out.println(rw.reverseWords("  "));
        System.out.println(rw.reverseWords("the sky is blue"));
        System.out.println(rw.reverseWords("  hello world!  "));
        System.out.println(rw.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder r = new StringBuilder(" ");
        StringBuilder wholeWord = new StringBuilder(" ");
        int index = 0;
        while (index != s.length()) {
            char c = s.charAt(index);
            if (c != ' ') {
                wholeWord.append(c);
            } else if (wholeWord.length() > 1) {
                r = wholeWord.append(r);
                wholeWord = new StringBuilder(" ");
            }
            index++;
        }
        if (wholeWord.length() > 1) {
            r = wholeWord.append(r);
        }
        return r.length() > 2 ? r.substring(1, r.length() - 1) : "";
    }

    /**
     * String r = " ";
     *         String wholeWord = " ";
     *         int index = 0;
     *         while (index != s.length()) {
     *             char c = s.charAt(index);
     *             if (c != ' ') {
     *                 wholeWord += c;
     *             } else if (wholeWord.length() > 1) {
     *                 r = wholeWord + r;
     *                 wholeWord = " ";
     *             }
     *             index++;
     *         }
     *         if (wholeWord.length() > 1) {
     *             r = wholeWord + r;
     *         }
     *         return r.length() > 2 ? r.substring(1, r.length() - 1) : "";
     */
}

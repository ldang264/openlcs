/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 * Example 1:
 * Input: word = "USA"
 * Output: true
 *
 * Example 2:
 * Input: word = "FlaG"
 * Output: false
 *
 * Constraints:
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00520s {
    public boolean detectCapitalUse(String word) {
        boolean flag = Character.isUpperCase(word.charAt(0)),  // 是否由大写字母开头
                up = false, lo = false;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) { // 当前字母是大写
                if (!flag || lo) return false; // 开头是小写或已经存在小写
                up = true;
            } else { // 当前字母是小写
                if (up) return false; // 已经存在大写，非法
                lo = true;
            }
        }
        return true;
    }
}

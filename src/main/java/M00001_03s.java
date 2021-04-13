/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例 1：
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 *
 * 示例 2：
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *
 * 提示：
 * 字符串长度在 [0, 500000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00001_03s {
    public String replaceSpaces(String S, int length) {
        if (length == S.length()) return S;
        char[] cs = S.toCharArray();
        int index = S.length() - 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == ' ') { // 是空格
                cs[index--] = '0';
                cs[index--] = '2';
                cs[index--] = '%';
            } else {
                cs[index--] = c;
            }
        }
        // 注意字符串最后可能还有无效预留长度
        return new String(cs, index + 1, S.length() - (index + 1));
    }

    public String replaceSpaces1(String S, int length) {
        if (length == S.length()) return S;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
}

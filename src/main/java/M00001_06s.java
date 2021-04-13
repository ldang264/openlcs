/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00001_06s {
    public String compressString(String S) {
        if (S.length() <= 2) return S;
        StringBuilder ans = new StringBuilder();
        int num = 1; // 字符计数器
        char prev = S.charAt(0), next;
        for (int i = 1; i < S.length(); i++) {
            next = S.charAt(i); // 当前字符
            if (prev != next) { // 结算prev
                ans.append(prev).append(num);
                num = 1; // 重置计数
            } else {
                num++; // 相等则计数+1
            }
            prev = next;
        }
        ans.append(prev).append(num);
        return ans.length() < S.length() ? ans.toString() : S;
    }
}

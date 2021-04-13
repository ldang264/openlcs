/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例1:
 * 输入: 
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 示例2:
 * 输入: 
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00001_05m {
    public boolean oneEditAway(String first, String second) {
        if (first == null) return second == null || second.length() <= 1;
        if (second == null) return first.length() <= 1;
        int len1 = first.length(), len2 = second.length();
        if (len1 == len2) {
            for (int i = 0; i < first.length() - 1; i++) {
                if (first.charAt(i) != second.charAt(i)) { // 不相等时判断它们剩余的字符串是否相等
                    return first.substring(i + 1).equals(second.substring(i + 1));
                }
            }
            return true;
        } else if (len1 - len2 == 1) {
            return edit(first, second);
        } else if (len2 - len1 == 1) {
            return edit(second, first);
        }
        return false; // 长度不能相差1个以上，否则不可能做到一次编辑
    }

    /**
     * 遍历较短的字符串，找第一个与长字符串不相等的字符，判断与其剩余长度是否相等
     * @param longer
     * @param shorter
     * @return
     */
    private boolean edit(String longer, String shorter) {
        for (int i = 0; i < shorter.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}

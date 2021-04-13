/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00001_01s {
    public boolean isUnique(String astr) {
        // 使用两个long长整型存储ASSIC字符，若已出现则该位为1
        long lower = 0/*存储0-63的字符*/, high = 0/*存储64-127的字符*/;
        for (int i = 0; i < astr.length(); i++) {
            int pos = astr.charAt(i);
            long p;
            if (pos < 64) {
                p = (1L << pos);
                if ((lower & p) != 0) return false; // 因为p是2的次幂，&结果等于0说明不存在
                lower |= p;
            } else {
                p = (1L << (pos - 64));
                if ((high & p) != 0) return false;
                high |= p;
            }
        }
        return true;
    }
}

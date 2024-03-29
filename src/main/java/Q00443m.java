

/**
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 *
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 *
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"] 13
 * ["a","b","1", "2"] 4
 * 输出：
 * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 *
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 * 提示：
 *
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00443m {

    /**
     * 方法比较笨，面试时基本很难AC
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int len = chars.length, num = 1;
        for (int i = len - 1; i >= 1; i--) {
            if (chars[i] == chars[i - 1]) { // 增加计数
                num++;
            } else if (num > 1){
                String str = String.valueOf(num);
                // 计数
                int j = 0;
                while (j < str.length()) {
                    chars[i + 1 + j] = str.charAt(j);
                    j++;
                }
                // 前移有效数据
                if (1 + j < num) {
                    for (int k = i + num; k < len; k++) {
                        chars[i + 1 + j] = chars[k];
                        j++;
                    }
                }
                len -= (num - str.length() - 1);
                num = 1;
            }
        }
        if (num > 1){
            String str = String.valueOf(num);
            // 计数
            int j = 0;
            while (j < str.length()) {
                chars[1 + j] = str.charAt(j);
                j++;
            }
            // 前移有效数据
            if (1 + j < num) {
                for (int k = num; k < len; k++) {
                    chars[1 + j] = chars[k];
                    j++;
                }
            }
            len -= (num - str.length() - 1);
        }
        return len;
    }

    /**
     *
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/string-compression/solution/ya-suo-zi-fu-chuan-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param chars
     * @return
     */
    public int compressAns(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

}

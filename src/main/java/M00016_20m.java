import java.util.ArrayList;
import java.util.List;

/**
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 *
 * 示例 1:
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 *
 * 示例 2:
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 *
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/t9-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00016_20m {

    /**
     * 将字符与数字映射起来
     * @param num
     * @param words
     * @return
     */
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> ans = new ArrayList<>();
        char[] cs = new char[128];
        cs['a'] = cs['b'] = cs['c'] = '2';
        cs['d'] = cs['e'] = cs['f'] = '3';
        cs['g'] = cs['h'] = cs['i'] = '4';
        cs['j'] = cs['k'] = cs['l'] = '5';
        cs['m'] = cs['n'] = cs['o'] = '6';
        cs['p'] = cs['q'] = cs['r'] = cs['s'] = '7';
        cs['t'] = cs['u'] = cs['v'] = '8';
        cs['w'] = cs['x'] = cs['y'] = cs['z'] = '9';
        char[] ns = num.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (; j < ns.length; j++) {
                if (cs[words[i].charAt(j)] != ns[j]) {
                    break;
                }
            }
            if (j == ns.length) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00008_07m {

    private List<String> list;

    private boolean[] visited;

    private char[] cs, temp;

    private int idx;

    public String[] permutation(String S) {
        list = new ArrayList<>();
        visited = new boolean[S.length()];
        temp = new char[S.length()];
        cs = S.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            backtrace(i);
        }
        return list.toArray(new String[0]);
    }

    private void backtrace(int i) {
        temp[idx++] = cs[i];
        visited[i] = true;
        if (idx == cs.length) {
            list.add(new String(temp));
        } else {
            for (int j = 0; j < cs.length; j++) {
                if (!visited[j]) {
                    backtrace(j); // 回溯未访问到的字符位置
                }
            }
        }
        idx--;
        visited[i] = false;
    }
}

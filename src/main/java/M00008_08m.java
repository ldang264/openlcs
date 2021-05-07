import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
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
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00008_08m {
    private List<String> list;

    private char[] cs, temp;

    private boolean[] visited;

    private int idx;

    public String[] permutation(String S) {
        list = new ArrayList<>();
        cs = S.toCharArray();
        temp = new char[S.length()];
        visited = new boolean[S.length()];
        Arrays.sort(cs);
        char prev = ' ';
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != prev) {
                prev = cs[i];
                backtrace(i);
            }
        }
        return list.toArray(new String[0]);
    }

    private void backtrace(int i) {
        temp[idx++] = cs[i];
        visited[i] = true;
        if (idx == cs.length) {
            list.add(new String(temp));
        } else if (i == 0 || visited[i - 1] || cs[i] != cs[i - 1]){ // i==0 或者 i-1访问过 或者 前后必须不相等
            for (int j = 0; j < cs.length; j++) {
                if (!visited[j]) {
                    backtrace(j);
                }
            }
        }
        idx--;
        visited[i] = false;
    }
}

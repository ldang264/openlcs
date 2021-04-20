import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00038m {

    private Set<String> ans; // set去重

    private boolean[] visited; // 标记是否加入

    private char[] temp; // 存储结果序列的临时数组

    private int index; // 当前已经存放的数组下标

    public String[] permutation(String s) {
        ans = new HashSet<>();
        visited = new boolean[s.length()];
        temp = new char[s.length()];
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        char prev = cs[0];
        backtrace(cs, 0);
        for (int i = 1; i < cs.length; i++) {
            if (prev != cs[i]) {
                prev = cs[i];
                backtrace(cs, i);
            }
        }
        return ans.toArray(new String[0]);
    }

    private void backtrace(char[] cs, int i) {
        temp[index++] = cs[i];
        visited[i] = true;
        if (index == cs.length) {
            ans.add(new String(temp));
        } else {
            for (int j = 0; j < cs.length; j++) { // 从0开始遍历
                if (!visited[j]) { // 未访问过的进行回溯
                    backtrace(cs, j);
                }
            }
        }
        visited[i] = false;
        index--;
    }
}

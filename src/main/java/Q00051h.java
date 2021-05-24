import java.util.*;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00051h {

    private List<List<String>> ans; // 结果

    private boolean[] columns, up2downs, down2ups; // 标记数组

    private int[] temp; // 存储每一列的位置

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        temp = new int[n];
        columns = new boolean[n]; // 标记列是否被占
        up2downs = new boolean[2 * n - 1]; // 标记左上到右下的对角线是否被占
        down2ups = new boolean[up2downs.length]; // 标记左下到右上的对角线是否被占
        backtrace(0);
        return ans;
    }

    private void backtrace(int i) {
        if (i == columns.length) {
            List<String> list = new ArrayList<>(columns.length);
            for (Integer idx : temp) {
                char[] cs = new char[temp.length];
                Arrays.fill(cs, '.');
                cs[idx] = 'Q';
                list.add(new String(cs));
            }
            ans.add(list);
        } else {
            int ud, du;
            for (int j = 0; j < columns.length; j++) {
                if (columns[j]) continue; // 列已经放了
                if (up2downs[ud = i - j + columns.length - 1]) continue; // 左上角到右下角已经放了
                if (down2ups[du = i + j]) continue; // 左下角到右上角已经放了
                columns[j] = true;
                up2downs[ud] = true;
                down2ups[du] = true;
                temp[i] = j;
                backtrace(i + 1);
                columns[j] = false;
                up2downs[ud] = false;
                down2ups[du] = false;
            }
        }
    }
}

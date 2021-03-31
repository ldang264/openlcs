import java.util.ArrayList;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..", // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.", // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00008_12h {

    private boolean[] columns; // 列

    private boolean[] up2down; // 左上到右下

    private boolean[] down2up; // 左下到右上

    private boolean[][] candidate;

    private List<List<String>> ans;

    /**
     * 对第一行进行遍历，剩余行回溯
     * 设置三个数组，用于存放列是否被占，左上到右下是否被占，左下到右上是否被占
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        columns = new boolean[n];
        up2down = new boolean[2 * n - 1]; // 最左下角(n - 1, 0),最右上角(0, n - 1)
        down2up = new boolean[2 * n - 1]; // (0, n - 1) 到 (n - 1, 0)
        candidate = new boolean[n][n];
        dfs(n, 0);
        return ans;
    }

    private void dfs(int n, int i) {
        if (i < n) {
            for (int j = 0; j < n; j++) {
                if (columns[j]) continue; // 列被占了
                int ud = i - j + (n - 1);
                if (up2down[ud]) continue; // 左上向右下被占了
                int du = i + j;
                if (down2up[du]) continue; // 右下向左上被占了
                columns[j] = true;
                up2down[ud] = true;
                down2up[du] = true;
                candidate[i][j] = true;
                dfs(n, i + 1); // 下一行
                columns[j] = false;
                up2down[ud] = false;
                down2up[du] = false;
                candidate[i][j] = false;
            }
        } else {
            // 加入返回列表
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (candidate[j][k]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
        }
    }
}

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
 *
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00130m {

    private int rMax, cMax;

    public void solve(char[][] board) {
        // 从4个边上的O向中心染色,用T做临时标记
        rMax = board.length - 1;
        cMax = board[0].length - 1;
        for (int j = 0; j <= cMax; j++) { // 染第一行
            dfs(board, 0, j);
        }
        if (rMax > 0) {
            for (int j = 0; j <= cMax; j++) { // 染最后一行
                dfs(board, rMax, j);
            }
        }
        for (int i = 1; i <= rMax; i++) { // 染第一列
            dfs(board, i, 0);
        }
        if (cMax > 0) { // 染最后一列
            for (int i = 1; i <= rMax; i++) { // 染最后一列
                dfs(board, i, cMax);
            }
        }
        for (int i = 0; i <= rMax; i++) {
            for (int j = 0; j <= cMax; j++) {
                if (board[i][j] == 'T') { // 还原临时标记
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') { // 真正要改的
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i <= rMax && j >= 0 && j <= cMax && board[i][j] == 'O') {
            board[i][j] = 'T';
            dfs(board, i + 1, j); // 下一行
            dfs(board, i - 1, j); // 上一行
            dfs(board, i, j + 1); // 右一列
            dfs(board, i, j - 1); // 左一列
        }
    }
}

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

    private List<List<String>> ans;

    private boolean[] columns; // 列数组

    private boolean[] tops; // 左上到右下的数组，行列的差总是相等，范围在-(n-1)到n-1

    private boolean[] bottoms; // 左下到右上的数组，行列的和总是相等，范围在0到2(n-1)

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        columns = new boolean[n];
        tops = new boolean[2 * n - 1];
        bottoms = new boolean[2 * n - 1];
        boolean[][] indexes = new boolean[n][n];
        find(n, 0, indexes);
        return ans;
    }

    private void find(int n, int i, boolean[][] indexes) {
        if (n == i) {
            List<String> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    sb.append(indexes[j][k] ? "Q" : ".");
                }
                rowList.add(sb.toString());
            }
            ans.add(rowList);
        } else {
            for (int j = 0; j < n; j++) {
                if (columns[j]) continue; // 行被占
                int iSj = i - j + (n - 1); // 避免越界
                if (tops[iSj]) continue; // 左上到右下的对角线被占
                int iAj = i + j;
                if (bottoms[iAj]) continue; // 左下到右上的对角线被占
                indexes[i][j] = true;
                columns[j] = true;
                tops[iSj] = true;
                bottoms[iAj] = true;
                find(n, i + 1, indexes); // 递归下一行
                indexes[i][j] = false;
                columns[j] = false;
                tops[iSj] = false;
                bottoms[iAj] = false;
            }
        }
    }
}

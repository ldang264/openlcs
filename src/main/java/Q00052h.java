

/**
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
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
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00052h {

    private int ans;

    private boolean[] columns; // 列数组

    private boolean[] tops; // 左上到右下的数组，行列的差总是相等，范围在-(n-1)到n-1

    private boolean[] bottoms; // 左下到右上的数组，行列的和总是相等，范围在0到2(n-1)

    public int totalNQueens(int n) {
        ans = 0;
        columns = new boolean[n];
        tops = new boolean[2 * n - 1];
        bottoms = new boolean[2 * n - 1];
        find(n, 0);
        return ans;
    }

    /**
     * 回溯
     * @param n
     * @param i
     */
    private void find(int n, int i) {
        if (n == i) {
            ans++;
        } else {
            for (int j = 0; j < n; j++) { // 在i行j列
                if (columns[j]) continue; // 列被占
                int iSj = (i - j) + (n - 1); // 避免越界
                if (tops[iSj]) continue; // 左上到右下对角线被占
                int iAj = i + j;
                if (bottoms[iAj]) continue; // 左下到右上对角线被占
                columns[j] = true;
                tops[iSj] = true;
                bottoms[iAj] = true;
                find(n, i + 1); // 下一行
                columns[j] = false;
                tops[iSj] = false;
                bottoms[iAj] = false;
            }
        }
    }
}

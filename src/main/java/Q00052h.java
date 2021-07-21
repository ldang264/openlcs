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

    private int ans; // 结果

    private boolean[] columns, up2downs, down2ups; // 标记数组

    public int totalNQueens(int n) {
        ans = 0;
        columns = new boolean[n]; // 标记列是否被占
        up2downs = new boolean[2 * n - 1]; // 标记左上到右下的对角线是否被占
        down2ups = new boolean[up2downs.length]; // 标记左下到右上的对角线是否被占
        backtrace(0);
        return ans;
    }

    private void backtrace(int i) {
        if (i == columns.length) {
            ans++;
        } else {
            int ud, du;
            for (int j = 0; j < columns.length; j++) {
                if (columns[j]) continue; // 列已经放了
                if (up2downs[ud = i - j + columns.length - 1]) continue; // 左上角到右下角已经放了
                if (down2ups[du = i + j]) continue; // 左下角到右上角已经放了
                columns[j] = true;
                up2downs[ud] = true;
                down2ups[du] = true;
                backtrace(i + 1);
                columns[j] = false;
                up2downs[ud] = false;
                down2ups[du] = false;
            }
        }
    }
}

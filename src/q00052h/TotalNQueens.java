package q00052h;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {
    public static void main(String[] args) {
        TotalNQueens tnq = new TotalNQueens();
        System.out.println(tnq.totalNQueens(5));
    }

    private int ans;

    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n <= 3) return 0;
        // n >= 4开始算
        int[][] qp;
        for (int i=0; i<n; i++) {
            qp = new int[n][n];  // n行n列，初始化都是0，0表示都可放皇后
            qp[i][0] = -n; // 标记为皇后
            color(qp, i, 0);
            tag(qp);
        }
        return ans;
    }

    /**
     *
     * @param qp
     */
    private void tag(int[][] qp) {
        for (int i=0; i<qp.length; i++) {
            boolean rowValid = false;
            for (int j=0; j<qp.length; j++) {
                if (qp[i][j] == 0) {
                    if (j < qp.length - 1) {
                        int[][] qp1 = new int[qp.length][qp.length];
                        for (int k=0; k<qp.length; k++) {
                            System.arraycopy(qp[k], 0, qp1[k], 0, qp.length);
                        }
                        qp1[i][j] = 1;
                        tag(qp1);
                    }
                    rowValid = true;
                    qp[i][j] = -qp.length;
                    color(qp, i, j);
                    break;
                } else if (qp[i][j] < 0) {
                    rowValid = true;
                    break;
                }
            }
            if (!rowValid) { // 一个可设置的位置都没有
                return;
            }
        }
        ans++;
    }

    private void color(int[][] qp, int i, int j) {
        for (int k=0; k<qp.length; k++) {
            qp[i][k] += 1; // 标记i行
            qp[k][j] += 1; // 标记j列
            if (i+j-k >= 0 && i+j-k < qp.length) {
                qp[k][i+j-k] += 1; // 右上往左下的对角线标记
            }
            if (j-i+k >= 0 && j-i+k < qp.length) {
                qp[k][j-i+k] += 1; // 左上往右下的对角线标记
            }
        }
    }

    /**
     for (int k=i+1; k<qp.length; k++) {

     }
     for (int j=0; j<i; j++) {
     qp[j][i] = 1;
     qp[i][j] = 1;// 该行左边被标记为1
     }
     for (int j=i+1; j<qp.length; j++) {
     qp[j][0] = 1;// 该列下面标记为1
     qp[i][j] = 1;// 该行右边标记为1
     }

     for (int j=i-1; j>=0; j--) {
     qp[j][j-i] = 1;
     }
     // 右下角对角线方向标记为1
     for (int j=i+1; j<qp.length; j++) {
     qp[j][j-i] = 1;
     }





     int col = 0;
     for (int i=0; i<qp.length; i++) { //行
     if (qp[i][col] == 0) {
     qp[i][col] = 2;
     }
     if (i == 0) {

     }
     for (int j=0; j<i; j++) {

     qp[j][i] = 1;// 该列上面被标记为1
     qp[i][j] = 1;// 该行左边被标记为1
     }
     for (int j=i+1; j<qp.length; j++) {
     qp[j][0] = 1;// 该列下面标记为1
     qp[i][j] = 1;// 该行右边标记为1
     }
     // 右上角对角线方向标记为1
     for (int j=i-1; j>=0; j--) {
     qp[j][j-i] = 1;
     }
     // 右下角对角线方向标记为1
     for (int j=i+1; j<qp.length; j++) {
     qp[j][j-i] = 1;
     }
     }
     */
}

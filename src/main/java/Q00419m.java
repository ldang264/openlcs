/**
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。战舰用'X'表示，空位用'.'表示。你需要遵守以下规则：
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由1xN (1 行, N 列)组成，或者Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔- 即没有相邻的战舰。
 *
 * 示例 :
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 *
 * 无效样例 :
 *
 * ...X
 * XXXX
 * ...X
 * 你不会收到这样的无效甲板- 因为战舰之间至少会有一个空位将它们分开。
 *
 * 进阶:
 * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00419m {

    /**
     * 题目竟然没看很懂。。。看了评论后，明白可以使用染色
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    int k = i + 1;
                    while (k < board.length) { // 向下染
                        if (board[k][j] == '.') break;
                        board[k][j] = '.';
                        k++;
                    }
                    k = j + 1;
                    while (k < board[0].length) { // 向右染
                        if (board[i][k] == '.') break;
                        board[i][k] = '.';
                        k++;
                    }
                    j = k; // 快速跳到该列，继续染
                }
            }
        }
        return ans;
    }

    /**
     * 很优秀的题解
     * @param board
     * @return
     */
    public int countBattleshipsAns(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') continue; // 不是战舰
                if (i > 0 && board[i - 1][j] == 'X') continue; // 如果上一行是战舰，则自己被染
                if (j > 0 && board[i][j - 1] == 'X') continue; // 如果左一列是战舰，则自己被染
                res++; // 自己是孤零零的战舰
            }
        }
        return res;
    }
}

package q00463s;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                ans += 4 - (i > 0 ? grid[i - 1][0] : 0) - (i < grid.length - 1 ? grid[i + 1][0] : 0) - (grid[i].length > 1 ? grid[i][1] : 0);
            }
            if (grid[i].length > 1 && grid[i][grid[i].length - 1] == 1) {
                ans += 4 - (i > 0 ? grid[i - 1][grid[i].length - 1] : 0) - (i < grid.length - 1 ? grid[i + 1][grid[i].length - 1] : 0) - grid[i][grid[i].length - 2];
            }
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            if (grid[0][i] == 1) {
                ans += 4 - grid[0][i - 1] - grid[0][i + 1] - (grid.length > 1 ? grid[1][i] : 0);
            }
            if (grid.length > 1 && grid[grid.length - 1][i] == 1) {
                ans += 4 - grid[grid.length - 1][i - 1] - grid[grid.length - 1][i + 1] - grid[grid.length - 2][i];
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 1) {
                    ans += 4 - grid[i - 1][j] - grid[i + 1][j] - grid[i][j - 1] - grid[i][j + 1];
                }
            }
        }
        return ans;
    }
}

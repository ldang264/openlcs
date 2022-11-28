/**
作者：hlxing
链接：https://leetcode.cn/problems/minimum-distance-to-type-a-word-using-two-fingers/solution/qing-xi-tu-jie-qiao-miao-de-dong-tai-gui-hua-by-hl/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Q01320h_Ans {
    public int minimumDistance(String word) {
        // 初始化
        int[][][] dp = new int[301][26][26];
        for (int i = 1; i <= 300; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int ans = Integer.MAX_VALUE;
        char[] ca = word.toCharArray();
        // 遍历每个字母
        for (int i = 1; i <= word.length(); i++) {
            int v = ca[i - 1] - 'A';
            // 遍历上一个阶段左指键位
            for (int l = 0; l < 26; l++) {
                // 遍历上一个阶段右指键位
                for (int r = 0; r < 26; r++) {
                    // 判断上一个阶段的状态是否存在
                    if (dp[i - 1][l][r] != Integer.MAX_VALUE) {
                        // 移动左指
                        dp[i][v][r] = Math.min(dp[i][v][r], dp[i - 1][l][r] + help(l, v));
                        // 移动右指
                        dp[i][l][v] = Math.min(dp[i][l][v], dp[i - 1][l][r] + help(r, v));
                    }
                    if (i == word.length()) {
                        ans = Math.min(ans, dp[i][v][r]);
                        ans = Math.min(ans, dp[i][l][v]);
                    }
                }
            }
        }
        return ans;
    }
    // 计算距离
    public int help(int a, int b) {
        int x = a / 6, y = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return (int)(Math.abs(x - x2)) + (int)(Math.abs(y - y2));
    }
}

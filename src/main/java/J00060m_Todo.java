import java.util.Arrays;

/**
 *
 */
public class J00060m_Todo {
    /**
     * 1 1 1 1 1 1
     *   2
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        // 和只会从n到6n
        int[] dp = new int[6 * n];
        Arrays.fill(dp, 0, 6, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i - 2; j < i * 6; j++) {
                dp[j + 1]++;
                dp[j + 2]++;

            }
            int end = 5 * i + 2;
            for (int j = 1; j <= end / 2; j++) {
                dp[j] += dp[j - 1];
                dp[end - j] = dp[j];
            }
        }
        System.out.println(Arrays.toString(dp));
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }
        double[] ans = new double[5 * n + 1];
        for (int i = 1; i < dp.length; i++) {
            ans[i - 1] = 1.00000 * dp[i] / sum;
        }
        return ans;
    }
}

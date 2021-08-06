/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * 提示：
 * 1 <= n <= 19
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00096m {

    /**
     * 二叉搜索树的性质是值在左子树<根<右子树
     * 从1遍历到n，取j作为根，1到j-1作为左子树，j+1到n作为右子树
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; // 1-n
        dp[0] = dp[1] = 1; // 空树或只有一个节点
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) { // 以j为根，从1到i的所有可能的二叉搜索树
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

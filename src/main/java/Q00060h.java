/**
 * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 *
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 *
 * 示例 2：
 * 输入：n = 4, k = 9
 * 输出："2314"
 *
 * 示例 3：
 * 输入：n = 3, k = 1
 * 输出："123"
 * 
 *
 * 提示：
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00060h {

    public String getPermutation(int n, int k) {
        int[] dp = new int[n + 1]; // 从1到n下标存放的是n!的值
        dp[0] = 1;
        StringBuilder ans = new StringBuilder(); // 初始化时是1-n字符串
        for (int i = 1; i <= n; i++) {
            ans.append(i); // 追加1-n
            dp[i] = i * dp[i - 1]; // 计算阶乘
        }
        int index = 0;
        int i = n;
        while (i > 1) { // 最多处理到i-1=1，最后一位无需处理
            if (k > dp[i - 1]) { // 小于等于阶乘，则取当前最小的整数
                int res = k % dp[i - 1];
                int d = k / dp[i - 1];
                if (res == 0) { // 余数为0表示取d这个数字的最大排列
                    if (d > 1) {
                        // 将j初的字符移到index处
                        int j = index + d - 1;
                        char c = ans.charAt(j);
                        ans.deleteCharAt(j);
                        ans.insert(index, c);
                    }
                    k = dp[i - 1]; // 在接下来都是取最后一个字符了
                } else {
                    // 将j初的字符移到index处
                    int j = index + d;
                    char c = ans.charAt(j);
                    ans.deleteCharAt(j);
                    ans.insert(index, c);
                    k = res;
                }
            }
            index++; // 处理下一位
            i--;
        }
        return ans.toString();
    }

    /**
     * 数学方法
     * @param n
     * @param k
     * @return
     */
    public String getPermutation1(int n, int k) {
        int[] dp = new int[n + 1]; // 从1到n下标存放的是n!的值
        dp[0] = 1;
        char[] ans = new char[n]; // 初始化时是1-n的字符
        for (int i = 1; i <= n; i++) {
            ans[i - 1] = (char) (i + '0'); // 追加1-n
            dp[i] = i * dp[i - 1]; // 计算阶乘
        }
        int index = 0, i = n;
        while (i > 1) { // 最多处理到i-1=1，最后一位无需处理
            if (k > dp[i - 1]) { // 小于等于阶乘，则取当前最小的整数
                int res = k % dp[i - 1];
                int d = k / dp[i - 1];
                if (res == 0) { // 余数为0表示取d这个数字的最大排列
                    if (d > 1) {
                        // 将j处的字符移到index处
                        int j = index + d - 1;
                        char c = ans[j];
                        ans[j] = ans[index];
                        ans[index] = c;
                    }
                    k = dp[i - 1]; // 在接下来都是取最后一个字符了
                } else {
                    // 将j处的字符移到index处
                    int j = index + d;
                    char c = ans[j];
                    ans[j] = ans[index];
                    ans[index] = c;
                    k = res;
                }
            }
            index++; // 处理下一位
            i--;
        }
        return new String(ans);
    }

}

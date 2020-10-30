package q00022m;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    /**
     * 自己的动态规划太垃圾，参考题解的同学的实现 注：似乎性能也不高
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> l1 = Arrays.asList("()");
        if (n == 1) {
            return l1;
        }
        List<List<String>> dp = new ArrayList<>(n + 1);
        dp.add(Arrays.asList(""));  // 0 ""
        dp.add(l1); // 1 "()"
        for (int i = 2; i <= n; i++) {
            List<String> dpi= new ArrayList<>();
            for (int j = 0; j <= i - 1; j++) {
                for (String s1 : dp.get(j)) {
                    for (String s2 : dp.get(i - 1 - j)) {
                        dpi.add("(" + s1 + ")" + s2); // dp[i]为从dp[k]拼接dp[i-1-k]的并集
                    }
                }
            }
            dp.add(dpi);
        }
        return dp.get(n);
    }

}

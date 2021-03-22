import java.util.Deque;
import java.util.LinkedList;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 示例：
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 * 提示：
 * 调用StockSpanner.next(int price)时，将有1 <= price <= 10^5。
 * 每个测试用例最多可以调用 10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用150000次StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00901m {

    private final Deque<int[]> stack; // 单调递减栈

    private int index;

    public Q00901m() {
        stack = new LinkedList<>();
    }

    public int next(int price) {
        int ans, size = stack.size();
        int[] top;
        while ((top = stack.peek()) != null && price >= top[1]) { // 清掉小于等于当前价格得
            stack.pop();
        }
        if (size == stack.size()) { // 没有变化，说明一个都没去掉
            ans = 1;
        } else if (stack.isEmpty()) { // 栈空了，前面的都比它小
            ans = index + 1;
        } else { // 与栈顶的下标比较
            ans = index - top[0];
        }
        stack.push(new int[]{index++, price});
        return ans;
    }

}

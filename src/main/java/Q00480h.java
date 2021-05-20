import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 * 示例：
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 * 提示：
 * 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *Example 2:
 *
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 *
 * Constraints:
 * 1 <= k <= nums.length <= 105
 * 231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00480h {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length + 1 - k];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 小根堆，存储较大的一半
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 大根堆，存储较小的一半
        boolean odd = (k & 1) == 1; // 奇数，只取一个队列；偶数则取平均值
        int i = 0, idx = 0;
        while (i < nums.length) {
            if (maxQueue.size() != minQueue.size()) { // 不一样，意味着小根堆数据多一个
                minQueue.offer(nums[i]); // 加入小根堆
                maxQueue.offer(minQueue.poll()); // 从小根堆取出最小的，加入大根堆
            } else { // 数据一样多
                maxQueue.offer(nums[i]); // 先加入大根堆
                minQueue.offer(maxQueue.poll()); // 把大根堆最大的那个，加入小根堆
            }
            i++;
            if (i >= k) { // 开始处理结果数据
                if (odd) { // k奇数
                    ans[idx] = minQueue.peek(); // 小根堆多出的那个元素
                    if (!minQueue.remove(nums[idx])) { // 尝试在小根堆中删除该元素
                        maxQueue.remove(nums[idx]); // 未删除成功，则必然在大根堆
                        maxQueue.offer(minQueue.poll()); // 小根堆比大根堆多两个元素，平衡一下
                    }
                } else { // k偶数
                    ans[idx] = maxQueue.peek() / 2.0d + minQueue.peek() / 2.0d; // 平均数
                    if (!maxQueue.remove(nums[idx])) { // 尝试在大根堆中删除该元素
                        minQueue.remove(nums[idx]); // 未删除成功，则必然在大根堆
                        minQueue.offer(maxQueue.poll()); // 大根堆比小根堆多一个元素，平衡一下
                    }
                }
                idx++;
            }
        }
        return ans;
    }
}

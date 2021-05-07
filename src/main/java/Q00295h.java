import java.util.ArrayList;
import java.util.List;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00295h {

    private final List<Integer> nums;

    /** initialize your data structure here. */
    public Q00295h() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if (nums.size() == 0 || num >= nums.get(nums.size() - 1)) {
            nums.add(num);
        } else if (num <= nums.get(0)) {
            nums.add(0, num);
        } else {
            int left = 1, right = nums.size() - 2, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums.get(mid) == num) {
                    nums.add(mid, num);
                    return;
                }
                if (nums.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            nums.add(left, num);
        }
    }

    public double findMedian() {
        if (nums.size() == 0) return 0;
        int mid = nums.size() >> 1;
        if ((nums.size() & 1) == 1)
            return nums.get(mid);
        return (nums.get(mid) + nums.get((mid) - 1)) / 2.00000;
    }
}

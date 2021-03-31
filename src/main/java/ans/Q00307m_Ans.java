package ans; /**
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 9
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 最多调用 3 * 104 次 update 和 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 线段树
 */
public class Q00307m_Ans {

    private int[] tree;

    private int n;

    public Q00307m_Ans(int[] nums) {
        n = nums.length;
        tree = new int[n * 2]; // 两倍原始数组的长度
        System.arraycopy(nums, 0, tree, n, n);
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int index, int val) {
        index += n;
        tree[index] = val; // 先更新当前下标的值
        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) { // 如果index是偶数，则right要为奇数
                right = index + 1;
            } else { // 如果index是奇数，则left要为偶数
                left = index - 1;
            }
            // parent is updated after child is updated
            tree[index /= 2] = tree[left] + tree[right];
        }
    }

    public int sumRange(int left, int right) {
        // get leaf with value 'left'
        left += n;
        // get leaf with value 'right'
        right += n;
        int sum = 0;
        while (left <= right) { // 只有左为偶数，右为奇数，才能直接在父节点查到
            if ((left % 2) == 1) { // 左界是奇数，需要额外加入
                sum += tree[left];
                left++;
            }
            if ((right % 2) == 0) { // 右界是偶数，需要额外加入
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

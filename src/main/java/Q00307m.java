/**
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
 * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
 * 
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
public class Q00307m {

    private int len;

    private int[] tree;

    public Q00307m(int[] nums) {
        len = nums.length;
        tree = new int[len << 1]; // 线段树的长度是原数组的二倍
        System.arraycopy(nums, 0, tree, len, len); // 复制到len后
        for (int i = len - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1]; // 计算区间和
        }
    }

    public void update(int index, int val) {
        index += len; // 定位到tree的位置
        if (val == tree[index]) return; // 相同就不更新了
        tree[index] = val; // 更新当前值
        int left, right;
        while (index > 0) {
            if ((index & 1) == 1) { // 奇数
                left = index - 1; // 左取偶数
                right = index;
            } else { // 偶数
                left = index;
                right = index + 1; // 右取奇数
            }
            tree[index >>= 1] = tree[left] + tree[right];
        }
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        left += len;
        right += len;
        while (left <= right) {
            if ((left & 1) == 1) { // 左为奇数
                ans += tree[left++];
            }
            if ((right & 1) == 0) { // 右为偶数
                ans += tree[right--];
            }
            left >>= 1;
            right >>= 1;
        }
        return ans;
    }
}

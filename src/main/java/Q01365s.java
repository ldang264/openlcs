/**
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * 以数组形式返回答案。
 *
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01365s {

    // 0:1,1:1,2:2,8:1
    // 0:0,1:1,2:2,8:4
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] helper = new int[101], // 计数
                dp = new int[101]; // 记和
        for (int i = 0; i < nums.length; i++) {
            helper[nums[i]]++;
        }
        dp[0] = 0;
        for (int i = 1; i < helper.length; i++) {
            dp[i] = dp[i - 1]; // 起码是前项和
            if (helper[i] > 0) { // 如果当前数量为正，需要加上前一项的计数
                dp[i] += helper[i - 1];
            } else {
                helper[i] = helper[i - 1]; // 否则传递计数
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[nums[i]];
        }
        return ans;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cell = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i]) {
                    cell++;
                }
            }
            ans[i] = cell;
        }
        return ans;
    }

    /**
     * 答案：计数排序
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrentAns(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }

}

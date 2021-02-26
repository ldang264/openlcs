/**
 * 给定一个整数数组 nums，按要求返回一个新数组counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
 *
 * 示例：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0] 
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00315h_Todo {
    /*public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0) return list;
        list.addFirst(0);
        int maxValue = nums[nums.length - 1];
        int minValue = maxValue;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= minValue) {
                list.addFirst(0);
                minValue = nums[i];
            } else if (nums[i] >= maxValue) {
                maxValue = nums[i];

                list.addFirst(nums[maxValue]);
            } else {
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < minValue) {
                        minValue = nums[j];
                    } else if (nums[j] > maxValue) {
                        maxValue = nums[j];
                    }
                    if (nums[j] < nums[i]) {
                        count++;
                    }
                }
                list.addFirst(count);
            }
        }
        return list;
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int[] ans = new int[nums.length];
        int maxIndex = nums.length - 1;
        int minIndex = maxIndex;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[minIndex]) {
                minIndex = nums[i];
            } else if (nums[i] >= nums[maxIndex]) {
                ans[i] = nums[maxIndex] + maxIndex - i;
                maxIndex = i;
            } else if (nums[i] == nums[maxIndex]) {
                list.addFirst(list.getFirst());
            } else {
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = nums[j];
                    } else if (nums[j] > nums[maxIndex]) {
                        maxIndex = nums[j];
                    }
                    if (nums[j] < nums[i]) {
                        count++;
                    }
                }
                list.addFirst(count);
            }
        }
        return list;
    }

     */
}

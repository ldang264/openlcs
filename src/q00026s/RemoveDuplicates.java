package q00026s;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates rp = new RemoveDuplicates();
        int[] nums1 = new int[]{1,1,2};
        int len1 = rp.removeDuplicates(nums1);
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len2 = rp.removeDuplicates(nums2);
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return nums.length;
        int index = 1;
        for (int i=0; i<nums.length - 1; i++) {
            if (nums[i+1] == nums[i]) { // 若前后相等
                for (int k=i+1; k<nums.length; k++) { // 从i+1开始往后遍历
                    if (nums[k] != nums[i]) { //找到不相等的
                        i = k-2; // k-2是因为外层for会+1，而nums[k-1]则是最后一个与nums[i]相等的
                        break; // 跳出循环
                    }
                }
            } else { // 不相等
                nums[index] = nums[i+1];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates1 (int[] nums) {
        if (nums.length < 1) return nums.length;
        int index = 1;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length;j++) {
                if (nums[j] != nums[i]) { // 找到了与当前不同的
                    nums[index] = nums[j];
                    index++;
                    if (j-i>1) {
                        i = nums.length;
                        for (int k=j+1; k<nums.length; k++) { // 将i移动到最后一个与nums[j]相等的位置
                            if (nums[k] != nums[j]) {
                                i = k-2;
                                break;
                            }
                        }

                    }
                }
                break;
            }
        }
        return index;
    }

    /**
     * 数组复制
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int size = nums.length;
        if(size <= 1) {
            return size;
        }
        int[] outs = new int[size];
        int index = 1;
        outs[0] = nums[0];
        for (int i=1; i< size; i++) {
            if (nums[i] != outs[index-1]) {
                outs[index] = nums[i];
                index++;
            }
        }
        System.arraycopy(outs, 0, nums, 0, outs.length);
        return index;
    }
}

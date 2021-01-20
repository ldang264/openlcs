import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00283s {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
            } else if (list.size() > 0){
                int z = list.removeFirst();
                swap(nums, z, i);
                list.add(i);
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]); // 非0的放入list
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i); // 挨个放进nums
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0; // 剩余的补0
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

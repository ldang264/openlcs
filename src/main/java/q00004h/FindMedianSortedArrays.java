package q00004h;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
        int[] a1 = new int[]{1, 3}, a2 = new int[]{2};
        int[] b1 = new int[]{1, 2}, b2 = new int[]{3, 4};
        int[] c1 = new int[]{0, 0}, c2 = new int[]{0, 0};
        int[] d1 = new int[]{}, d2 = new int[]{1};
        int[] e1 = new int[]{2}, e2 = new int[]{};
        System.out.println(fmsa.findMedianSortedArrays(a1, a2));
        System.out.println(fmsa.findMedianSortedArrays(b1, b2));
        System.out.println(fmsa.findMedianSortedArrays(c1, c2));
        System.out.println(fmsa.findMedianSortedArrays(d1, d2));
        System.out.println(fmsa.findMedianSortedArrays(e1, e2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0, index1=0, index2 =0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                nums[index++] = nums1[index1++];
            } else {
                nums[index++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            nums[index++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            nums[index++] = nums2[index2++];
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[(nums.length - 1) / 2];
        }
    }
}

package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 算法描述
 *
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 平均时间复杂度：O(nlogn) 最好：O(nlogn) 最坏：O(n^2)
 * 空间复杂度：O(logn)
 * 是否占用额外内存：否
 * 是否稳定：否
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        // 保证两端索引不会交叉越过  同时保证递归能够结束避免死循环
        // 当pivot左边没有元素 left=0 right=-1
        // 当pivot左边只有一个元素  left=0  right=0
        if (left >= right) {
            return;
        }
        // 保存最左端在过程中left不被修改  修改l
        int l = left;
        // 保存最右端在过程中right不被修改  修改r
        int r = right;
        // 取中轴 （取第一个数为中轴）
        int pivot = array[left];
        // 如果左边和右边索引没碰撞   或者没交叉越界   说明元素还没找完  继续找
        while (left < right) {
            // 循环里的比较方向如下
            // left →                    ← right
            //   ↓                          ↓
            //   2  6   5   7   9   1   3   4

            // 下面两个循环必须是从right--这个循环开始 因为我们开始取中轴取的是第一个数 并且间接性的把他给保存起来了
            // 又因为left停留在第一个位置 所以就先从右边开始找，找到比pivot小的数就往left位置放

            // left < right 是为了保证right不会小于0而导致索引越界，极端情况下12345 该循环会一直--到-1然后导致越界
            // array[right] >= pivot 如果=true证明当前元素比pivot大  那么继续right--往前一个找
            while (left < right && array[right] >= pivot) {
                right--;
            }
            // 循环退出证明arr[right]比pivot小  就把arr[right]往left放
            array[left] = array[right];
            // 同理 array[left] <= pivot 如果=true证明当前元素比pivot小  那么继续right--往前一个找
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 同理 循环退出证明arr[left]比pivot大  就把arr[left]往right放
            array[right] = array[left];
        }
        // 循环结束的时候也就是left和right碰撞的时候
        // 碰撞时：碰撞的左边全是比pivot小的元素   碰撞的右边都是比pivot大的元素  所以碰撞时的位置就是中轴要放的位置
        // 因为碰撞时left==right 所以这里使用left或者right都行
        array[left] = pivot;
        // 把中轴左边的元素 再次取中轴找左右边的元素
        sort(array, l, left - 1);
        // 把中轴右边的元素 再次取中轴找左右边的元素
        sort(array, left + 1, r);
        //递归到中轴的左边、右边只剩一个元素则排序完成 因为只剩一个元素中轴前面的元素一定是比中轴小 ，只剩一个元素中轴后面的元素一定比中轴大
    }

}

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *
 * 提示：
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-missing-positive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01539s {
    public int findKthPositive(int[] arr, int k) {
        int last = 0, i = 0, dist;
        while (i < arr.length && k > 0) {
            dist = arr[i] - last; // 计算前后两个数之间的间隙
            if (k < dist) return last + k; // 如果间隙比剩余的k都大了，则直接返回
            k -= dist - 1; // 否则将整个区间的数都减掉
            last = arr[i]; // 更新上一个数
            i++;
        }
        return last + k; // 加上剩余的k
    }
}

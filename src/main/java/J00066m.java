/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00066m {

    /**
     * 一个数组，来回用两次
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;
        int[] ans = new int[a.length];
        ans[0] = 1;
        for (int i = 1; i < a.length; i++) {
            ans[i] = ans[i - 1] * a[i - 1]; // i是前所有项的积
        }
        for (int i = a.length - 2; i >= 0; i--) {
            ans[i] *= a[i + 1]; // 前后所有项的乘积，即为结果数组
            a[i] *= a[i + 1]; // i是其后所有项的积
        }
        return ans;
    }

    /**
     * 左右、右左两个数组
     * @param a
     * @return
     */
    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0) return a;
        int[] lr = new int[a.length];
        lr[0] = 1;
        int[] rl = new int[a.length];
        rl[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            lr[i] = lr[i - 1] * a[i - 1];
            rl[a.length - 1 - i] = rl[a.length - i] * a[a.length - i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = lr[i] * rl[i];
        }
        return a;
    }
}

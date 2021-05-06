/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 * 输入: num = 1775(110111011112)
 * 输出: 8
 *
 * 示例 2：
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00005_03s {
    // 1111011001
    // 1111111111
    // 01110
    public int reverseBits(int num) {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            arr[i] = num & 1;
            num >>= 1;
        }
        int ans = 1, left = -1, right = 0, last = -1;
        while (right < arr.length) {
            if (arr[right] == 0) {
                if (last >= 0) { // 大于1个0才更新left
                    left = last;
                }
                last = right;
            }
            ans = Math.max(ans, right - left); // 每次都计算
            right++;
        }
        return ans == 32 ? 32 : last == -1 ? ans + 1 : ans;
    }
}

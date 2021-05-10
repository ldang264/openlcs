import java.util.Arrays;

/**
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 *
 * 示例:
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *
 * 注意:
 *
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00593m {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] arr = new int[6];
        arr[0] = exec(p1, p2);
        arr[1] = exec(p1, p3);
        arr[2] = exec(p1, p4);
        arr[3] = exec(p2, p3);
        arr[4] = exec(p2, p4);
        arr[5] = exec(p3, p4);
        Arrays.sort(arr);
        return arr[0] > 0 &&
                arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3] &&
                arr[4] == arr[5] &&
                arr[4] == 2 * arr[3];
    }

    /**
     * 计算点距
     * @param a
     * @param b
     * @return
     */
    private int exec(int[] a, int[] b) {
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        return x * x + y * y;
    }
}

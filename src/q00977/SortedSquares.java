package q00977;

import java.util.Arrays;

/**
 *给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares ss = new SortedSquares();
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{-1,1})));
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{-1,-1})));
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{0,1})));
    }

    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int j = 0;
        int index = 0;
        for (int i=0; i<A.length && A[i] < 0; i++) {
            index++;
        }
        for (int i=index; i<A.length; i++) {
            int a2 = A[i] * A[i];
            if (index == 0) {
                B[j] = a2;
            } else {
                int temp2 = A[index-1] * A[index-1];
                if (a2 > temp2) {
                    B[j] = temp2;
                    index--;
                    i--;
                } else {
                    B[j] = a2;
                }
            }
            j++;
        }
        while (index > 0) {
            int temp2 = A[index-1] * A[index-1];
            B[j] = temp2;
            index--;
            j++;
        }
        return B;
    }
}

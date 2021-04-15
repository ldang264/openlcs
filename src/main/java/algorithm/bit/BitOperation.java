package algorithm.bit;

/**
 * &	与	两个位都为1时，结果才为1
 * |	或	两个位都为0时，结果才为0
 * ^	异或	两个位相同为0，相异为1     0^0=0  0^1=1  1^0=1  1^1=0
 * ~	取反	0变1，1变0
 * <<	左移	各二进位全部左移若干位，高位丢弃，低位补0
 * >>	右移	各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
 */
public class BitOperation {

    // 与运算 &

    /**
     * 低位清零
     * @param a
     * @return
     */
    public int setZero(int a) {
        return a & (a - 1);
    }

    /**
     * 判断奇偶
     * 只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a % 2 == 0)来判断a是不是偶数。
     * @param a
     * @return
     */
    public boolean isOdd(int a) {
        return (a & 1) == 1;
    }

    // 异或运算 ^
    /**
     * 参加运算的两个对象，如果两个相应位相同为0，相异为1。
     * 运算规则：0^0=0  0^1=1  1^0=1  1^1=0
     *
     * 异或的几条性质:
     * 1、交换律
     * 2、结合律 (a^b)^c == a^(b^c)
     * 3、对于任何数x，都有 x^x=0，x^0=x
     * 4、自反性: a^b^b=a^0=a;
     */

    /**
     * 翻转指定位
     * 比如将数 X=1010 1110 的低4位进行翻转，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000 1111，然后将X与Y进行异或运算（X^Y=1010 0001）即可得到。
     * @param a
     * @return
     */
    public int reverse(int a) {
        return a ^ Integer.MAX_VALUE;
    }

    /**
     * 与0相异或值不变
     * 例如：1010 1110 ^ 0000 0000 = 1010 1110
     * @param a
     * @return
     */
    public int self(int a) {
        return a ^ 0;
    }

    /**
     * 交换两个数
     * @param arr
     * @param a
     * @param b
     */
    public void swap(int[] arr, int a, int b) {
        if (a != b){
            arr[a] ^= arr[b];
            arr[b] ^= arr[a];
            arr[a] ^= arr[b];
        }
    }
}

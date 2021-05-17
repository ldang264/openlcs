/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00009s {

    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) return true; // 0-9是回文数
        if (x < 0 || x % 10 == 0) return false; // 负数或以0结尾的不是回文数
        int y = 0;
        while (x > y) { // 若x<=y，则肯定不是回文了
            int temp = x / 10;
            if (temp == y) return true; // 奇数位的最终将通过此处判断
            y = y * 10 + x % 10; // y为从x的个位数开始往高位的数字
            if (temp == y) return true; // 偶数位的最终将通过此处判断
            x = temp; // x每次循环后踢掉自己最低位
        }
        return false;
    }
}

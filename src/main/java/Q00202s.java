import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00202s {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return exec(n, set);
    }

    private boolean exec(int n, Set<Integer> set) {
        int temp = 0;
        while (n >= 10) {
            int g = n % 10;
            n /= 10;
            temp += g * g;
        }
        int nn = n * n + temp; // 算平方和
        if (nn == 1) return true; // true
        if (set.contains(nn)) return false; // 如果死循环，则false
        set.add(nn);
        return exec(nn, set);
    }
}

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00925s {
    public static void main(String[] args) {
        Q00925s ilpn = new Q00925s();
        System.out.println(ilpn.isLongPressedName("alex", "aaleex"));
        System.out.println(ilpn.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(ilpn.isLongPressedName("leelee", "lleeelee"));
        System.out.println(ilpn.isLongPressedName("laiden", "laiden"));
        System.out.println(ilpn.isLongPressedName("alex", "aaleelx"));
        System.out.println(ilpn.isLongPressedName("alex", "alexxr"));
        System.out.println(ilpn.isLongPressedName("leelee", "lleelee"));
    }

    public boolean isLongPressedName(String name, String typed) {
        if (typed == null) {
            return name == null;
        } else if (name == null) {
            return true;
        } else if (typed.length() < name.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            int ck = 0;
            while (j < typed.length() - 1) {
                if (typed.charAt(j) != typed.charAt(j+1)) {
                    break;
                }
                j++;
                ck++;
            }
            if (ck > 0) {
                while (i < name.length() - 1) {
                    if (name.charAt(i) != name.charAt(i+1)) {
                        break;
                    }
                    ck--;
                    i++;
                }
                if (ck < 0) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return i == name.length() && j == typed.length();
    }
}

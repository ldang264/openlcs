import java.util.*;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00017m {

    private List<String> ans;

    private char[] temp;

    private int idx;

    private Map<Character, char[]> map;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        temp = new char[digits.length()];
        idx = 0;
        backtrace(digits, 0);
        return ans;
    }

    /**
     * 回溯
     * @param digits
     * @param i
     */
    private void backtrace(String digits, int i) {
        if (i == digits.length()) {
            ans.add(new String(temp));
        } else {
            for (char c : map.get(digits.charAt(i))) { // 遍历当前字符
                temp[idx++] = c;
                backtrace(digits, i + 1);
                idx--;
            }
        }
    }

    /**
     * 动态规划
     * @param digits
     * @return
     */
    public List<String> letterCombinationsDp(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, List<String>> characterMap = new HashMap<>(8);
        characterMap.put('2', Arrays.asList("a", "b", "c"));
        characterMap.put('3', Arrays.asList("d", "e", "f"));
        characterMap.put('4', Arrays.asList("g", "h", "i"));
        characterMap.put('5', Arrays.asList("j", "k", "l"));
        characterMap.put('6', Arrays.asList("m", "n", "o"));
        characterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        characterMap.put('8', Arrays.asList("t", "u", "v"));
        characterMap.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String> prev = characterMap.get(digits.charAt(0)), next;
        for (int i = 1; i < digits.length(); i++) {
            next = new ArrayList<>();
            List<String> ics = characterMap.get(digits.charAt(i));
            for (String s : prev) {
                for (String ic : ics) {
                    next.add(s + ic);
                }
            }
            prev = next;
        }
        return prev;
    }
}

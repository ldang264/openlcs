import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * 提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00187m {

    /**
     * 参考答案，自己写
     * 映射字符为数字，计算hash值
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();
        int hp = (int) Math.pow(5, 9);
        int[] map = new int[128];
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        Set<Integer> codes = new HashSet<>();
        Set<String> values = new HashSet<>();
        int hash = 0;
        for (int i = 0; i < 10; i++) { // 先算好前10位
            hash += map[s.charAt(i)] * Math.pow(5, i);
        }
        codes.add(hash);
        for (int i = 1; i <= s.length() - 10; i++) {
            hash = hash / 5 + map[s.charAt(i + 9)] * hp; // 减掉低位的hash值，加上高位的
            if (!codes.add(hash)) {
                values.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(values);
    }

    /**
     * 比较普通的方法，时间复杂度为O（N * 10）
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> temp = new HashSet<>();
        Set<String> help = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (!temp.add(subStr)) { // 已存在则会返回false
                help.add(subStr);
            }
        }
        return new ArrayList<>(help);
    }

}

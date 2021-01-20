import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00763s {
    public static void main(String[] args) {
        Q00763s pl = new Q00763s();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(pl.partitionLabels("eaaaabaaec"));
        System.out.println(pl.partitionLabels("dccccbaabe"));
    }

    public List<Integer> partitionLabels(String S) {
        int[]
                nums1 = new int[26],
                nums2 = new int[26],
                cs = new int[26];
        int i = 1, j = 1;
        nums1[S.charAt(0) - 'a'] = -1;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (nums1[c - 'a'] == 0) {
                nums1[c - 'a'] = i;
                cs[j++] = c - 'a';
            }
            nums2[c - 'a'] = i;
            i++;
        }
        nums1[S.charAt(0) - 'a'] = 0;
        cs[0] = S.charAt(0) - 'a';
        List<Integer> list = new ArrayList<>();
        int high = nums2[cs[0]];
        int sum = 0;
        for (int k = 1; k < j; k++) {
            int curr = cs[k];
            if (nums1[curr] > high) {
                int sub = nums1[curr] - sum;
                list.add(sub);
                sum += sub;
                high = nums2[curr];
            } else if (nums2[curr] > high) {
                high = nums2[curr];
            }
        }
        list.add(S.length() - sum);
        return list;
    }
}

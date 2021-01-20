import java.util.ArrayList;
import java.util.List;

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00763s_Ans {
    public static void main(String[] args) {
        Q00763s_Ans pl = new Q00763s_Ans();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(pl.partitionLabels("eaaaabaaec"));
        System.out.println(pl.partitionLabels("dccccbaabe"));
    }
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i; // 将所有字符出现的最大下标放入数组
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']); // end是到i之前的最大数字
            if (i == end) { // 如果已经搜索到i，则计算一下这个区间的长度
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}

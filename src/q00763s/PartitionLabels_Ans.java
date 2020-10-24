package q00763s;

import java.util.ArrayList;
import java.util.List;

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PartitionLabels_Ans {
    public static void main(String[] args) {
        PartitionLabels_Ans pl = new PartitionLabels_Ans();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(pl.partitionLabels("eaaaabaaec"));
        System.out.println(pl.partitionLabels("dccccbaabe"));
    }
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}

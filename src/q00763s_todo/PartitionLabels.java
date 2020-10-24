package q00763s_todo;

import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        int i = 0;
        int index = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (nums1[c-97] == 0) {
                nums1[c-97] = i;
            }
            nums2[c-97] = i;
            i++;
        }
        if (S.charAt(0) == 97) {
            nums1[0] = 0;
        }
        i = 0;
        while (i < nums1.length - 1) {
            if (nums2[i] > 0) {

            }
            i++;
        }

        return null;
    }
}

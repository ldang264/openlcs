package q01002s;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CommonChars {

    public static void main(String[] args) {
        CommonChars cc = new CommonChars();
        String[] a1 = new String[] {"bella","label","roller"};
        String[] a2 = new String[] {"cool","lock","cook"};
        System.out.println(cc.commonChars(a1));
        System.out.println(cc.commonChars(a2));
    }

    public List<String> commonChars(String[] A) {
        int[][] array = new int[A.length][26]; // A.length行26列
        for (int i = 0; i < A.length; i++) {
            for (int j=0; j<A[i].length(); j++) {
                char ch = A[i].charAt(j);
                array[i][ch - 97] += 1; // 第一列对应a的个数，第二列对应b的个数......
            }
        }
        List<String> list = new ArrayList<>(8);
        for (int i=0; i<26; i++) { // 遍历26列
            int min = 100; // 根据提示，设置min为100即可
            for (int j=0; j<A.length; j++) {
                if (array[j][i] < min) {
                    min = array[j][i]; // 找最小值
                }
            }
            for (int k=0; k<min; k++) {
                list.add(String.valueOf((char) (i + 97))); // 将min个该字符对应的个数加入到list
            }
        }
        return list;
    }
}

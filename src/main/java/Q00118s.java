import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00118s {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) return ans;
        ans.add(Collections.singletonList(1));
        if (numRows == 1) return ans;
        ans.add(Arrays.asList(1, 1));
        if (numRows == 2) return ans;
        for (int i = 2; i < numRows; i++) {
            List<Integer> lastList = ans.get(i - 1);
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            for (int j = 1; j < i; j++) {
                rowList.add(lastList.get(j - 1) + lastList.get(j));
            }
            rowList.add(1);
            ans.add(rowList);
        }
        return ans;
    }
}

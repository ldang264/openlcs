/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 * words的长度在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00010_05s {
    public int findString(String[] words, String s) {
        int c;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                c = words[i].compareTo(s);
                if (c == 0) return i;
                if (c > 0) break;
            }
        }
        return -1;
    }
}

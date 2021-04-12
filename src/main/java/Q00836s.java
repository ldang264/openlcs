/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *
 * 示例 3：
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 *
 * 提示：
 * rect1.length == 4
 * rect2.length == 4
 * -109 <= rec1[i], rec2[i] <= 109
 * rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3]
 * rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00836s {

    /**
     * 参考了答案和评论
     *
     * 矩形如果不重叠，从x轴和y轴上看两个矩形就变成了两条线段，这两条线段肯定是不相交的。
     * x轴，左边的矩形的最右边小于右边矩形的最左边，即rec1[2] < rec2[0] || rec2[2] < rec1[0]；
     * y轴，下面的矩形的最上边小于上面矩形的最下边，即rec1[3] < rec2[1] || rec2[3] < rec1[1]。
     * 因为题目要求重叠算相离，所以加上=，最后取反
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] == rec1[2] || rec1[1] == rec1[3] // 处理rec1是线段或者点的问题
                || rec2[0] == rec2[2] || rec2[1] == rec2[3] // 处理rec2是线段或者点的问题
                || rec1[2] <= rec2[0] || rec2[2] <= rec1[0] // 左边矩形最右边小于等于右边矩形最左边
                || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]); // 下边矩形最上边小于等于上边矩形最下边
    }

    /**
     * 思路
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与
     * x 轴平行的边（水平边）投影到
     * x 轴上时会有交集，与
     * y 轴平行的边（竖直边）投影到
     * y 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题。
     *
     * 算法
     * 矩形 rec1 和 rec2 的水平边投影到
     * x 轴上的线段分别为 (rec1[0], rec1[2]) 和 (rec2[0], rec2[2])。根据数学知识我们可以知道，当 min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]) 时，这两条线段有交集。对于矩形 rec1 和 rec2 的竖直边投影到
     * y 轴上的线段，同理可以得到，当 min(rec1[3], rec2[3]) > max(rec1[1], rec2[1]) 时，这两条线段有交集。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapAns(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

}

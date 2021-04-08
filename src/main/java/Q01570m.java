import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个稀疏向量，计算它们的点积（数量积）。
 * 实现类SparseVector：
 * SparseVector(nums)以向量nums初始化对象。
 * dotProduct(vec)计算此向量与vec的点积。
 * 稀疏向量 是指绝大多数分量为 0 的向量。你需要 高效 地存储这个向量，并计算两个稀疏向量的点积。
 *
 * 进阶：当其中只有一个向量是稀疏向量时，你该如何解决此问题？
 *
 * 示例 1：
 * 输入：nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
 * 输出：8
 * 解释：v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
 *
 * 示例 2：
 * 输入：nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
 * 输出：0
 * 解释：v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
 *
 * 示例 3：
 * 输入：nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
 * 输出：6
 *
 * 提示：
 * n == nums1.length == nums2.length
 * 1 <= n <= 10^5
 * 0 <= nums1[i], nums2[i]<= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dot-product-of-two-sparse-vectors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01570m {

    private Map<Integer, Integer> values;

    Q01570m(int[] nums) {
        values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                values.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(Q01570m vec) {
        Map<Integer, Integer> others = vec.values;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            Integer otherVal = others.get(entry.getKey());
            if (otherVal != null) {
                ans += entry.getValue() * otherVal;
            }
        }
        return ans;
    }

    /*
    private List<int[]> values;

    Q01570m(int[] nums) {
        values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                values.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(Q01570m vec) {
        List<int[]> others = vec.values;
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < values.size() && j < others.size()) {
            int[] value = values.get(i);
            int[] other = others.get(j);
            if (value[0] > other[0]) {
                j++;
            } else if (value[0] < other[0]) {
                i++;
            } else {
                ans += value[1] * other[1];
                i++;
                j++;
            }
        }
        return ans;
    }*/
}

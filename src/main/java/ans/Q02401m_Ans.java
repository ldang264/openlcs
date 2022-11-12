package ans;
/**
给你一个由 正 整数组成的数组 nums 。

如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。

返回 最长 的优雅子数组的长度。

子数组 是数组中的一个 连续 部分。

注意：长度为 1 的子数组始终视作优雅子数组。

 

示例 1：

输入：nums = [1,3,8,48,10]
输出：3
解释：最长的优雅子数组是 [3,8,48] 。子数组满足题目条件：
- 3 AND 8 = 0
- 3 AND 48 = 0
- 8 AND 48 = 0
可以证明不存在更长的优雅子数组，所以返回 3 。
示例 2：

输入：nums = [3,1,5,11,13]
输出：1
解释：最长的优雅子数组长度为 1 ，任何长度为 1 的子数组都满足题目条件。
 

提示：

1 <= nums.length <= 105
1 <= nums[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-nice-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Q02401m_Ans {
    boolean check(List<String> list, String s, int[] cnt) {
        int n = s.length();
        boolean f = true;
        for (int i = n - 1, j = 0; i >= 0; --i, ++j) {
            if (s.charAt(i) == '1' && cnt[j] == 1) {
                f = false;
                break;
            }
        }
        return f;
    }

    public int longestNiceSubarray(int[] nums) {
        int[] cnt = new int[32];
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (int n : nums) {
            list.add(Integer.toBinaryString(n));
        }

        int ans = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            String s = list.get(r);
            if (check(list,s,cnt)){
                ans= Math.max(ans, r-l+1);
                ++r;
                for (int i = s.length() - 1, j = 0; i >= 0; --i, ++j) {
                    if (s.charAt(i)=='1')cnt[j]=1;
                }
            } else {
                while (!check(list, s,cnt)){
                    String q=list.get(l);
                    for (int i = q.length() - 1, j = 0; i >= 0; --i, ++j) {
                        if (q.charAt(i)=='1')cnt[j]=0;
                    }
                    ++l;
                }
            }
        }
        return ans;
    }
}

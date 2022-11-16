package ans;
/**
Alice 是 n 个花园的园丁，她想通过种花，最大化她所有花园的总美丽值。

给你一个下标从 0 开始大小为 n 的整数数组 flowers ，其中 flowers[i] 是第 i 个花园里已经种的花的数目。已经种了的花 不能 移走。同时给你 newFlowers ，表示 Alice 额外可以种花的 最大数目 。同时给你的还有整数 target ，full 和 partial 。

如果一个花园有 至少 target 朵花，那么这个花园称为 完善的 ，花园的 总美丽值 为以下分数之 和 ：

完善 花园数目乘以 full.
剩余 不完善 花园里，花的 最少数目 乘以 partial 。如果没有不完善花园，那么这一部分的值为 0 。
请你返回 Alice 种最多 newFlowers 朵花以后，能得到的 最大 总美丽值。

 

示例 1：

输入：flowers = [1,3,1,1], newFlowers = 7, target = 6, full = 12, partial = 1
输出：14
解释：Alice 可以按以下方案种花
- 在第 0 个花园种 2 朵花
- 在第 1 个花园种 3 朵花
- 在第 2 个花园种 1 朵花
- 在第 3 个花园种 1 朵花
花园里花的数目为 [3,6,2,2] 。总共种了 2 + 3 + 1 + 1 = 7 朵花。
只有 1 个花园是完善的。
不完善花园里花的最少数目是 2 。
所以总美丽值为 1 * 12 + 2 * 1 = 12 + 2 = 14 。
没有其他方案可以让花园总美丽值超过 14 。
示例 2：

输入：flowers = [2,4,5,3], newFlowers = 10, target = 5, full = 2, partial = 6
输出：30
解释：Alice 可以按以下方案种花
- 在第 0 个花园种 3 朵花
- 在第 1 个花园种 0 朵花
- 在第 2 个花园种 0 朵花
- 在第 3 个花园种 2 朵花
花园里花的数目为 [5,4,5,5] 。总共种了 3 + 0 + 0 + 2 = 5 朵花。
有 3 个花园是完善的。
不完善花园里花的最少数目为 4 。
所以总美丽值为 3 * 2 + 4 * 6 = 6 + 24 = 30 。
没有其他方案可以让花园总美丽值超过 30 。
注意，Alice可以让所有花园都变成完善的，但这样她的总美丽值反而更小。
 

提示：

1 <= flowers.length <= 105
1 <= flowers[i], target <= 105
1 <= newFlowers <= 1010
1 <= full, partial <= 105

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-total-beauty-of-the-gardens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Q02234h_Ans {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        long n = flowers.length;
        if (flowers[0] >= target) return n * full; // 剪枝，此时所有花园都是完善的

        var leftFlowers = newFlowers - target * n; // 填充后缀后，剩余可以种植的花
        for (var i = 0; i < n; ++i) {
            flowers[i] = Math.min(flowers[i], target); // 去掉多余的花
            leftFlowers += flowers[i]; // 补上已有的花
        }

        var ans = 0L;
        var sumFlowers = 0L;
        for (int i = 0, x = 0; i <= n; ++i) { // 枚举后缀长度 n-i
            if (leftFlowers >= 0) {
                // 计算最长前缀的长度
                while (x < i && (long) flowers[x] * x - sumFlowers <= leftFlowers)
                    sumFlowers += flowers[x++]; // 注意 x 只增不减，二重循环的时间复杂度为 O(n)
                var beauty = (n - i) * full; // 计算总美丽值
                if (x > 0) beauty += Math.min((leftFlowers + sumFlowers) / x, (long) target - 1) * partial;
                ans = Math.max(ans, beauty);
            }
            if (i < n) leftFlowers += target - flowers[i];
        }
        return ans;
    }
}

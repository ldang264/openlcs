/**
 * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 示例1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * [-2,-2,-2,3,3]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * 示例 2:
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * [-1, -1, 1]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 提示:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 104
 * 0 <= gas[i], cost[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00134m {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        gas[0] -= cost[0]; // 计算前缀和，gas[i]将表示油量到i下标时的剩余油量，负数表示缺口数
        int minIndex = 0; // 表示缺口最大，即油最缺的下标
        for (int i = 1; i < gas.length; i++) {
            gas[i] = gas[i - 1] + (gas[i] - cost[i]); // 前缀和
            if (gas[i] < gas[minIndex]) { // 更新最缺油的下标
                minIndex = i;
            }
        }
        return gas[gas.length - 1] < 0 ? -1 // 全程下来都缺油
                : minIndex == gas.length - 1 ? 0 // 如果最缺油的是倒数第一个位置，则从0开始
                : minIndex + 1; // 下一个就是起点
    }

    /**
     * 暴力法，时间26ms
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] > cost[i]) {
                int curr = 0;
                boolean can = true;
                for (int j = i; j < gas.length; j++) {
                    curr += gas[j] - cost[j];
                    if (curr < 0) { // 走不下去了
                        can = false;
                        break;
                    }
                }
                if (!can) continue;
                for (int j = 0; j <= i; j++) {
                    curr += gas[j] - cost[j];
                    if (curr < 0) { // 走不下去了
                        can = false;
                        break;
                    }
                }
                if (can) return i;
            }
        }
        return -1;
    }

}

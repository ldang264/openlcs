import java.util.*;

/**
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00380m {

    private Map<Integer, Integer> map;

    private List<Integer> list;

    private Random r;

    /** Initialize your data structure here. */
    public Q00380m() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        return list.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer currIndex = map.remove(val); // 获取当前要删除的下标
        if (currIndex == null) return false; // 不存在，直接返回false
        int endIndex = list.size() - 1; // 拿到列表的最后一个下标
        int endValue = list.remove(endIndex); // 把最后一个元素删除并得到它的值
        if (currIndex != endIndex) { // 如果刚好是最后一个下标，不需要往前换
            list.set(currIndex, endValue); // 将当前下标替换为最后一个下标的元素，然后删除最后一个下标
            map.put(endValue, currIndex); // 更新最后一个元素的新下标
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.size() == 0 ? -1 : list.get(r.nextInt(list.size()));
    }
}

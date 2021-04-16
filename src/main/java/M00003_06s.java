import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 示例1:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 *
 * 示例2:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 *
 * 说明:
 * 收纳所的最大容量为20000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/animal-shelter-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00003_06s {

    private static final int[] NONE = new int[]{-1, -1};

    private int globalIndex; // 全局编号

    private final Queue<int[]> catQueue, dogQueue;

    public M00003_06s() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        int[] a = new int[]{animal[0], animal[1], globalIndex}; // 构造队列的对象，3个元素的数组
        globalIndex++;
        if (animal[1] == 0) {
            catQueue.offer(a);
        } else {
            dogQueue.offer(a);
        }
    }

    public int[] dequeueAny() {
        if (catQueue.size() > 0 && dogQueue.size() > 0) {
            return catQueue.peek()[0] > dogQueue.peek()[0] ? Arrays.copyOf(catQueue.poll(), 2) : Arrays.copyOf(dogQueue.poll(), 2);
        }
        if (catQueue.size() > 0) return Arrays.copyOf(catQueue.poll(), 2);
        if (dogQueue.size() > 0) return  Arrays.copyOf(dogQueue.poll(), 2);
        return NONE;
    }

    public int[] dequeueDog() {
        return dogQueue.size() > 0 ?  Arrays.copyOf(dogQueue.poll(), 2) : NONE;
    }

    public int[] dequeueCat() {
        return catQueue.size() > 0 ? Arrays.copyOf(catQueue.poll(), 2) : NONE;
    }
}

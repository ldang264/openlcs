package algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 算法描述
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 平均时间复杂度：O(nlogn) 最好：O(nlogn) 最坏：O(nlogn)
 * 空间复杂度：O(1)
 * 是否占用额外内存：否
 * 是否稳定：否
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] array) {
        //1.将无序序列构建为一个大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        //2.将堆顶元素与末尾元素交换，最大元素沉淀到末尾
        //3.重复这个过程
        for (int j = array.length - 1; j > 0; j--) {
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, j);
        }
        return array;
    }

    //将一个数组(二叉树)，调整为一个大顶堆
    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];//先取出当前元素的值，保存在临时变量
        // 开始调整
        // 说明：
        // 1、k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {         //右节点比左节点的值大
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;//k指向右子结点
            }
            if (array[k] > temp) {//如果子结点大于父结点
                array[i] = array[k];//把较大的值赋值给当前结点
                i = k;//i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父结点的树的最大值放在了最顶(局部)
        array[i] = temp;//将temp值放到调整后的位置
    }

}

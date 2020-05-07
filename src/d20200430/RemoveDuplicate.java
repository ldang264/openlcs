package d20200430;

public class RemoveDuplicate {

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int[] nums = new int[]{1, 1, 2};
        int len = removeDuplicate.removeDuplicates(nums);
        System.out.println(len);
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size <= 1) {
            return size;
        }
        int[] outs = new int[size];
        int index = 1;
        outs[0] = nums[0];
        for (int i=1; i< size; i++) {
            if (nums[i] != outs[index-1]) {
                outs[index] = nums[i];
                index++;
            }
        }
        System.arraycopy(outs, 0, nums, 0, outs.length);
        return index;
    }
}

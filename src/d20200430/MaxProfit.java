package d20200430;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit main = new MaxProfit();
        int profit1 = main.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(profit1);
        int profit2 = main.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(profit2);
        int profit3 = main.maxProfit(new int[]{7,6,4,3,1});
        System.out.println(profit3);
    }

    public int maxProfit(int[] prices) {
        int result = 0;

        int size = prices.length;
        if (size == 1) {
            return result;
        }
        int min = prices[0];
        int max = -1;
        for (int i=1; i<size; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }

            if (prices[i] <= max) {
                result += max - min;
                min = prices[i];
                max = -1;
            }
        }
        return result;
    }
}

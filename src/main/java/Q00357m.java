public class Q00357m {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) return 10;
        int sum = 9;
        for (int i = 1; i < n; i++) {
            sum *= (10 - i);
        }
        return countNumbersWithUniqueDigits(n - 1) + sum;
    }

}

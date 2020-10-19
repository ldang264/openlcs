package q00050m;

/**
 *
 */
public class MyPow_QuickMul {
    public static void main(String[] args) {
        MyPow_QuickMul mp = new MyPow_QuickMul();
        double x1 = 2.00000, x2 = 2.10000, x3 = 2.00000, x4 = 0.00001;
        int    n1 = 10     , n2 = 3      , n3 = -2,      n4 = 2147483647;
        System.out.println(mp.myPow(x1, n1));
        System.out.println(mp.myPow(x2, n2));
        System.out.println(mp.myPow(x3, n3));
        System.out.println(mp.myPow(x4, n4));
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}

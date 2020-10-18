package q00050m_todo;

/**
 *
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow mp = new MyPow();
        double x1 = 2.00000, x2 = 2.10000, x3 = 2.00000;
        int    n1 = 10     , n2 = 3      , n3 = -2;
        System.out.println(mp.myPow(x1, n1));
        System.out.println(mp.myPow(x2, n2));
        System.out.println(mp.myPow(x3, n3));
    }

    public double myPow(double x, int n) {
        if (x == 1 || n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        int abs = Math.abs(n);
        double ans = pow(x, 1, abs);
        return n > 0 ? ans : 1/ans;
    }

    private double pow(double x, int l, int r) {
        if (l == r) {
            return x;
        }
        if (l > r) {
            return -1;
        }
        int mid = (l + r) >> 1;
        return exec(pow(x, l, mid), pow(x, mid + 1, r));
    }

    private double exec(double ld, double rd) {
        return ld * rd;
    }
}

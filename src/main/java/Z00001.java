import java.util.HashSet;
import java.util.Set;

public class Z00001 {
    private Set<Integer> set = new HashSet<>(32);

    public int solution(int A, int B, int C, int D) {
        return check(A, B, C, D) +
                check(A, B, D, C) +
                check(A, C, B, D) +
                check(A, C, D, B) +
                check(A, D, B, C) +
                check(A, D, C, B) +
                check(B, A, C, D) +
                check(B, A, D, C) +
                check(B, C, A, D) +
                check(B, C, D, A) +
                check(B, D, A, C) +
                check(B, D, C, A) +
                check(C, B, A, D) +
                check(C, B, D, A) +
                check(C, A, B, D) +
                check(C, A, D, B) +
                check(C, D, B, A) +
                check(C, D, A, B) +
                check(D, B, C, A) +
                check(D, B, A, C) +
                check(D, C, B, A) +
                check(D, C, A, B) +
                check(D, A, B, C) +
                check(D, A, C, B)
                ;
    }

    private int check(int h1, int h2, int m1, int m2) {
        int h = h1 * 10 + h2;
        int m = m1 * 10 + m2;
        return (h >= 24 || m >= 60 || !set.add(h * 60 + m)) ? 0 : 1;
    }
}

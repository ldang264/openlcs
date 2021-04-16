import org.junit.Test;

import static org.junit.Assert.*;

public class M00003_01sTest {


    @Test
    public void test() {
        M00003_01s m00003_01s = new M00003_01s(2);
        m00003_01s.push(0, 1);
        m00003_01s.push(0, 2);
        m00003_01s.push(0, 3);
        m00003_01s.pop(0);
        m00003_01s.pop(0);
        m00003_01s.pop(0);
        m00003_01s.peek(0);
        /*["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]*/
    }

}
import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;
import static org.junit.Assert.*;
import org.junit.Test;


public class FilkTest {

    @Test
    public void testsame() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.
        */
        for (int i = 1; i < 500; i++) {
            assertTrue(Flik.isSameNumber(i, i));
            print(i);
        }


    }
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FilkTest.class);
    }


}

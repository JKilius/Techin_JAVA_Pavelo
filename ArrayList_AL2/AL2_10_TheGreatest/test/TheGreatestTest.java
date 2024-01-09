import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class TheGreatestTest {

    public ArrayList<Integer> a(int... i) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int j : i) {
            al.add(j);
        }
        return al;
    }

    @Test
    public void test1() {
        testGreatest(1, 1);
        testGreatest(2, 2);
        testGreatest(3, 3);
    }

    @Test
    public void test2() {
        testGreatest(3, 1, 2, 3);
        testGreatest(3, 3, 2, 1);
        testGreatest(2, 2, 2, 2, 2, 2, 2, 2);
        testGreatest(3, -1, 1, -2, 2, -3, 3);
        testGreatest(-1, -2, -1, -3);
        testGreatest(-9000, -9000, -9001);
    }

    private void testGreatest(int greatest, int... numbers) {
        try {
            assertEquals("Greatest of the list " + Arrays.toString(numbers) + " not correct.", greatest,
                    TheGreatest.greatest(a(numbers)));
        } catch (Exception e) {
            fail("Error when calculating greatest of list " + Arrays.toString(numbers) + ".\n " + e.toString());
        }
    }
}

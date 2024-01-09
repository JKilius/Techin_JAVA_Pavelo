import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;


public class MoreThanOnceTest {
    
    public ArrayList<Integer> a(int... i ) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int j : i) {
            al.add(j);
        }
        return al;
    }

    public void test(ArrayList<Integer> lista, int luku, boolean b) {
        assertEquals("Answer wrong when parameter was list "+lista+" and value "+luku,
                     b,
                     MoreThanOnce.moreThanOnce(lista,luku));
    }

    @Test
    public void test1() {
        test(a(1),1,false);
        test(a(2),2,false);
        test(a(2),1,false);
        test(a(1),2,false);
    }

    @Test
    public void test2() {
        test(a(),1,false);
        test(a(),9000,false);
    }

    @Test
    public  void test3() {
        test(a(2,2,2,2,2,2),2,true);
        test(a(2,2,2,2,2,2),3,false);
        test(a(1,2,3,4,6),5,false);
        test(a(1,2,3,4,3),3,true);
        test(a(0,7,9,-1,13,8,-1),-1,true);
        test(a(0,7,9,-1,13,8,-1),8,false);
        test(a(0,7,9,-1,13,8,-1),-2,false);
    }

}

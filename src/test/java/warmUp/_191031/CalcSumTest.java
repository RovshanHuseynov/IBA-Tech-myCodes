package warmUp._191031;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcSumTest {

    CalcSum t;
    @Before
    public void aaaa(){
        t = new CalcSum();
    }

    @After
    public void bbb(){
        System.out.println("After");
    }

    @Test
    public void m1() {
        assertEquals("3/3", t.splitPlus("1/3+2/3"));
    }

    @Test
    public void m2() {
        assertEquals("3", t.splitPlus("1+2"));
    }

    @Test
    public void m3() {
        assertEquals("4/3", t.splitPlus("1+1/3"));
    }

    @Test
    public void m10() {
        assertEquals("41/6", t.splitPlus("1/3+2/3+6/3+1+2+1/3+1/2"));
    }
}
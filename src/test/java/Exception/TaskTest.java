package Exception;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    Task t;
    @Before
    public void aaaa(){
        t = new Task();
    }

    @After
    public void bbb(){
        System.out.println("After");
    }

    @Test
    public void calcSum1() {
        assertEquals(0, t.calcSum("dcdsfsd"));
    }

    @Test
    public void calcSum2() {
        assertEquals(1, t.calcSum("1 fsfs"));
    }

    @Test
    public void calcSum3() {
        assertTrue(t.isZero(0));
    }
}
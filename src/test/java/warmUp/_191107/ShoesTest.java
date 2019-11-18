package warmUp._191107;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoesTest {

    Shoes s;

    @Before
    public void before() {
        s = new Shoes();
    }

    @After
    public void after() {
        System.out.println("Test finished");
    }

    @Test
    public void calc1() throws IllegalAccessException {
        assertEquals(1 , s.solution("LLLRRR"));
    }

    @Test
    public void calc2() throws IllegalAccessException {
        assertEquals(2 , s.solution("RLRL"));
    }

    @Test
    public void calc3() throws IllegalAccessException {
        assertEquals(1 , s.solution("RRLL"));
    }

    @Test
    public void calc4() throws IllegalAccessException {
        assertEquals(2 , s.solution("RLRRLL"));
    }

    @Test
    public void calc5() throws IllegalAccessException {
        assertEquals(1 , s.solution("RRLRLRLRLRLL"));
    }

    @Test
    public void calc6() throws IllegalAccessException {
        assertEquals(1 , s.solution("LLRLRLRLRLRLRLRR"));
    }

    @Test
    public void calc7() throws IllegalAccessException {
        assertEquals(3 , s.solution("RLLRRL"));
    }

    @Test
    public void calc8() throws IllegalAccessException {
        //assertEquals(3 , s.solution("LLLRLLRRL"));
    }
}
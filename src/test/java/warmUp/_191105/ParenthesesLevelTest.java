package warmUp._191105;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesesLevelTest {

    ParenthesesLevel p;

    @Before
    public void before() {
        p = new ParenthesesLevel();
    }

    @After
    public void after() {
    }

    @Test
    public void calc1() throws IllegalAccessException {
        assertEquals(1, p.calc("()").getParenthesesLevel());
        assertEquals(".", p.calc("aa(b.bbb)").getAl().get(2));
    }

    @Test
    public void calc2() throws IllegalAccessException {
        assertEquals(1, p.calc("()()()"));
    }

    @Test
    public void calc3() throws IllegalAccessException {
        assertEquals(2, p.calc("(())()()"));
    }

    @Test
    public void calc4() throws IllegalAccessException {
        assertEquals(3, p.calc("()(()())((()))()(())"));
    }

    @Test
    public void calc5() throws IllegalAccessException {
        assertEquals(4, p.calc("(((())))"));
    }

    @Test
    public void calc6() throws IllegalAccessException {
        assertEquals(5, p.calc("((((()))))"));
    }
}
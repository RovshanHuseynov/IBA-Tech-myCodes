package bigInteger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionTest {
    Addition c;

    @Before
    public void setUp() throws Exception {
        this.c = new Addition();
    }

    @Test
    public void add1() {
        assertEquals("579", c.add("123", "456"));
    }

    @Test
    public void add2() {
        assertEquals("123", c.add("100", "23"));
    }

    @Test
    public void add3() {
        assertEquals("1001", c.add("999", "2"));
    }

    @Test
    public void add4() {
        assertEquals("3", c.add("1", "2"));
    }

    @Test
    public void add5() {
        assertEquals("211", c.add("11", "200"));
    }

    @Test
    public void add6() {
        assertEquals("12", c.add("3", "9"));
    }
}
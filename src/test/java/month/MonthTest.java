package month;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonthTest {
    Month month;

    public MonthTest() {
        this.month = new Month();
    }

    @Test
    public void month1() {
        assertEquals(31, month.run(1));
    }

    @Test
    public void month2() {
        assertEquals(28, month.run(2));
    }

    @Test
    public void month3() {
        assertEquals(31, month.run(3));
    }

    @Test
    public void month4() {
        assertEquals(30, month.run(4));
    }

    @Test
    public void month5() {
        assertEquals(31, month.run(5));
    }

    @Test
    public void month6() {
        assertEquals(30, month.run(6));
    }

    @Test
    public void month7() {
        assertEquals(31, month.run(7));
    }

    @Test
    public void month8() {
        assertEquals(31, month.run(8));
    }

    @Test
    public void month9() {
        assertEquals(30, month.run(9));
    }

    @Test
    public void month10() {
        assertEquals(31, month.run(10));
    }

    @Test
    public void month11() {
        assertEquals(30, month.run(11));
    }

    @Test
    public void month12() {
        assertEquals(31, month.run(12));
    }
}
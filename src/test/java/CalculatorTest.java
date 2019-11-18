import oldLessons.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @After
    public void after(){
    }

    @Before
    public void before(){
        this.calc = new Calculator();
    }

    @Test
    public void add() {
        boolean flag = (5 == calc.add(2,3) )? true : false ;
        assertTrue(flag);
    }

    @Test
    public void sub() {
        boolean flag = (10 == calc.sub(20,10) )? true : false ;
        assertTrue(flag);
    }

    @Test
    public void mul() {
        boolean flag = (100 == calc.mul(25,4) )? true : false ;
        assertTrue(flag);
    }

    @Test
    public void div() {
        boolean flag = (6 == calc.div(24,4) )? true : false ;
        assertTrue(flag);
    }
}
package com.calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import com.calculator.Calc;
@SpringBootTest
class calcTest {

    @Test
    void testAddNumbers() {
        ICalc calcTest = new Calc();
        Assertions.assertEquals(4, calcTest.calculate("2+2"));
    }
    @Test
    void testSubNumbers() {
        ICalc calcTest = new Calc();
        Assertions.assertEquals(1, calcTest.calculate("3-2"));
    }
    @Test
    void testMultiplyNumbers() {
        ICalc calcTest = new Calc();
        Assertions.assertEquals(100, calcTest.calculate("50*2"));
    }
    @Test
    void testDivideNumbers() {
        ICalc calcTest = new Calc();
        Assertions.assertEquals(25, calcTest.calculate("50/2"));
    }
    @Test
    void testAllInONe(){
        ICalc calcTest = new Calc();
        Assertions.assertEquals(50, calcTest.calculate("50/2*2+2-2"));
    }

}
package com.mb.util;

import com.mb.exception.FailureException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorUtilTest {

    @Test
    public void shouldReturnExpression() {
        assertEquals(new BigDecimal(36), CalculatorUtil.evalIgnoreMathPrec("10 + 2 * 3"));
    }

    @Test(expected = FailureException.class)
    public void shouldReturn() {
        CalculatorUtil.evalIgnoreMathPrec("10 + 2 s 3");
    }

    @Test(expected = FailureException.class)
    public void shouldThrowFailureExceptionWhenWrongOperator() {
        CalculatorUtil.calculate("5", "$", "2");
    }

    @Test(expected = FailureException.class)
    public void shouldThrowFailureExceptionWhenWrongNum() {
        CalculatorUtil.calculate("a", "*", "2");
    }

    @Test
    public void shouldAdd() {
        assertEquals(new BigDecimal(4), CalculatorUtil.calculate("2", "+", "2"));
    }

    @Test
    public void shouldDiff() {
        assertEquals(new BigDecimal(4), CalculatorUtil.calculate("8", "-", "4"));
    }

    @Test
    public void shouldMultiply() {
        assertEquals(new BigDecimal(8), CalculatorUtil.calculate("4", "*", "2"));
    }

    @Test
    public void shouldDivide() {
        assertEquals(new BigDecimal(2), CalculatorUtil.calculate("8", "/", "4"));
    }
}
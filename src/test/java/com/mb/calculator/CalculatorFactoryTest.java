package com.mb.calculator;

import com.mb.OperatorsEnum;
import com.mb.calculator.operators.Addition;
import com.mb.calculator.operators.Difference;
import com.mb.calculator.operators.Division;
import com.mb.calculator.operators.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowILE() {
        CalculatorFactory.getOperation("$");
    }

    @Test
    public void shouldReturnAdditionCalculation() {
        assertTrue(CalculatorFactory
                .getOperation(OperatorsEnum.ADD.getOperator())
                .apply(new BigDecimal(6), new BigDecimal(2))
                .validated() instanceof Addition);
    }

    @Test
    public void shouldReturnDifferenceCalculation() {
        assertTrue(CalculatorFactory
                .getOperation(OperatorsEnum.SUBTRACT.getOperator())
                .apply(new BigDecimal(6), new BigDecimal(2))
                .validated() instanceof Difference);
    }

    @Test
    public void shouldReturnMultiplicationCalculation() {
        assertTrue(CalculatorFactory
                .getOperation(OperatorsEnum.MULTIPLY.getOperator())
                .apply(new BigDecimal(6), new BigDecimal(2))
                .validated() instanceof Multiplication);
    }

    @Test
    public void shouldReturnDivisionCalculation() {
        assertTrue(CalculatorFactory
                .getOperation(OperatorsEnum.DIVIDE.getOperator())
                .apply(new BigDecimal(6), new BigDecimal(2))
                .validated() instanceof Division);
    }
}
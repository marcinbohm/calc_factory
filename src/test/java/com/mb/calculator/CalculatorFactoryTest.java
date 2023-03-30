package com.mb.calculator;

import com.mb.OperatorsEnum;
import com.mb.calculator.operators.Addition;
import com.mb.calculator.operators.Difference;
import com.mb.calculator.operators.Division;
import com.mb.calculator.operators.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowILE() {
        CalculatorFactory.getInstance("$");
    }

    @Test
    public void shouldReturnAdditionCalculation() {
        assertTrue(CalculatorFactory.getInstance(OperatorsEnum.ADD.getOperator()) instanceof Addition);
    }

    @Test
    public void shouldReturnDifferenceCalculation() {
        assertTrue(CalculatorFactory.getInstance(OperatorsEnum.SUBTRACT.getOperator()) instanceof Difference);
    }

    @Test
    public void shouldReturnMultiplicationCalculation() {
        assertTrue(CalculatorFactory.getInstance(OperatorsEnum.MULTIPLY.getOperator()) instanceof Multiplication);
    }

    @Test
    public void shouldReturnDivisionCalculation() {
        assertTrue(CalculatorFactory.getInstance(OperatorsEnum.DIVIDE.getOperator()) instanceof Division);
    }
}
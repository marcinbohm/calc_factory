package expression;

import com.mb.OperatorsEnum;
import com.mb.Pair;
import com.mb.calculator.CalculatorFactory;
import com.mb.calculator.operators.Division;
import com.mb.exception.FailureException;
import com.mb.expression.MathExpressionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MathExpressionFactoryTest {

    @Test(expected = FailureException.class)
    public void shouldReturnFailureExceptionWhenApplyValueIsNull() {
        Queue<Pair<String, Integer>> expressionElements = new LinkedList<>();
        expressionElements.add(new Pair<>("multiply", 10));
        expressionElements.add(new Pair<>("divide", 10));
        Integer applyValue = null;

        MathExpressionFactory mathExpressionFactory = new MathExpressionFactory(new StringBuilder());

        mathExpressionFactory.getExpression(expressionElements, applyValue);
    }

    @Test
    public void shouldReturnExpression() {
        Queue<Pair<String, Integer>> expressionElements = new LinkedList<>();
        expressionElements.add(new Pair<>("multiply", 3));
        expressionElements.add(new Pair<>("add", 2));
        Integer applyValue = 10;

        MathExpressionFactory mathExpressionFactory = new MathExpressionFactory(new StringBuilder());

        assertEquals("10 * 3 + 2", mathExpressionFactory.getExpression(expressionElements, applyValue));
    }
}
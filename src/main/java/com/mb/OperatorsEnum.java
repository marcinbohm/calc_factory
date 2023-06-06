package com.mb;

import com.mb.calculator.Calculator;
import com.mb.calculator.operators.Addition;
import com.mb.calculator.operators.Difference;
import com.mb.calculator.operators.Division;
import com.mb.calculator.operators.Multiplication;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperatorsEnum {

    ADD("+", "add", Addition::new),
    SUBTRACT("-", "subtract", Difference::new),
    DIVIDE("/", "divide", Division::new),
    MULTIPLY("*", "multiply", Multiplication::new),
    APPLY("", "apply", null);

    private final String operator;
    private final String name;

    private final BiFunction<BigDecimal, BigDecimal, Calculator> operation;

    OperatorsEnum(String operator, String name, BiFunction<BigDecimal, BigDecimal, Calculator> operation) {
        this.operator = operator;
        this.name = name;
        this.operation = operation;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getName() {
        return this.name;
    }

    public BiFunction<BigDecimal, BigDecimal, Calculator> getOperation() {
        return operation;
    }

    public static Optional<OperatorsEnum> fromOperator(String operator) {
        return Stream.of(OperatorsEnum.values())
                .filter(myEnum -> myEnum.getOperator().equals(operator))
                .findFirst();
    }

    public static Optional<OperatorsEnum> fromName(String name) {
        return Stream.of(OperatorsEnum.values())
                .filter(myEnum -> myEnum.getName().equals(name))
                .findFirst();
    }

    public static Set<String> getOperatorsSet() {
        return Stream.of(OperatorsEnum.values())
                .map(OperatorsEnum::getOperator)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "OperatorsEnum{" +
                "code='" + operator + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

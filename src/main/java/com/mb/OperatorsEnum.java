package com.mb;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperatorsEnum {

    ADD("+", "add"),
    SUBTRACT("-", "subtract"),
    DIVIDE("/", "divide"),
    MULTIPLY("*", "multiply"),
    APPLY("", "apply");

    private final String operator;
    private final String name;

    OperatorsEnum(String operator, String name) {
        this.operator = operator;
        this.name = name;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getName() {
        return this.name;
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

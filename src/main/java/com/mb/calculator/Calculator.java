package com.mb.calculator;

import java.math.BigDecimal;

public abstract class Calculator {

    private final BigDecimal num1;
    private final BigDecimal num2;

    protected Calculator(BigDecimal num1, BigDecimal num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract BigDecimal calculate();

    public Calculator validated() {
        return this;
    }

    public BigDecimal getNum1() {
        return num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }
}

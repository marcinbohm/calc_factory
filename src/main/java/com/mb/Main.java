package com.mb;

import com.mb.exception.FailureException;
import com.mb.service.CalculationService;
import com.mb.util.CalculatorUtil;
import com.mb.expression.MathExpressionFactory;
import com.mb.files.FileReader;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        CalculationService.calculateExpressionsFromFile();
    }
}
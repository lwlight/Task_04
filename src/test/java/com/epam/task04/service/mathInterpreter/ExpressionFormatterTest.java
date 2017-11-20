package com.epam.task04.service.mathInterpreter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionFormatterTest {
    private ExpressionFormatter expressionFormatter = ExpressionFormatter.getInstance();

    @Test
    public void ShouldReturnCorrectlyFormattedExpressionWhenInputIsCorrect(){
        String inputExpression = "3+5*2+--j*++i";
        int valueForI = 55;
        int valueForJ = 90;
        String expected = "3 + 5 * 2 + 89 * 56";
        String result = expressionFormatter.formateMathExpression(inputExpression, valueForI, valueForJ);
        Assert.assertEquals(result, expected);
    }

}
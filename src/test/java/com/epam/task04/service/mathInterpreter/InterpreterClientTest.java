package com.epam.task04.service.mathInterpreter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterpreterClientTest {
    InterpreterClient interpreterClient = InterpreterClient.getInstance();
    @Test
    public void shouldReturnCorrectStringWhenRpnGiven() {
        String input = "3 5 2 * +";
        String expected = "13";
        String result = interpreterClient.calculate(input);
        Assert.assertEquals(result, expected);
    }

}
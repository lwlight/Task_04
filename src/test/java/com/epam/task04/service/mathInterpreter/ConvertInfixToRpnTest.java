package com.epam.task04.service.mathInterpreter;

import org.junit.Assert;
import org.junit.Test;


public class ConvertInfixToRpnTest {
    private ConvertInfixToRpn convertInfixToRpn = new ConvertInfixToRpn();

    @Test
    public void shouldReturnRpnStringWhenInputIsCorrect() {
        String input = "3 + 5 * 2";
        String expected = "3 5 2 * +";
        String result = convertInfixToRpn.convertInfixToRPN(input);
        Assert.assertEquals(result, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputContainsLetters() {
        String input = "3 + 5 * 2 * a  \\ 7";
        String result = convertInfixToRpn.convertInfixToRPN(input);
    }



}
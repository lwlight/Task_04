package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LexemesHandlerTest {
    private LexemesHandler lexemesHandler = new LexemesHandler();
    @Test
    public void shouldReturnComponentWithTwentyThreeLexemesWhenExecuted(){
        String inputTextString = "It is a (-5+1/2*(3+5*2---j))*1200 established fact.\nThat a reader will be of a page when looking at its layout.\nBye.";
        int inputForI = 100;
        int inputForJ = 500;
        int expectedParagraphCount = 23;
        Component component = lexemesHandler.handleRequest(inputTextString, inputForI, inputForJ);
        int result = component.getComponents().size();
        Assert.assertEquals(expectedParagraphCount, result);
    }

}
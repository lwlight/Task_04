package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandlerManagerTest {
    private HandlerManager handlerManager = HandlerManager.getInstance();

    @Test
    public void shouldReturnComponentWithTwoParagraphesWhenExecuted(){
        String inputTextString = "It is a (-5+1/2*(3+5*2---j))*1200 established fact that a reader will be of a page when looking at its layout.\nBye.";
        int inputForI = 10;
        int inputForJ = 50;
        int expectedParagraphCount = 2;
        Component component = handlerManager.buildComponent(inputTextString, inputForI, inputForJ);
        int result = component.getComponents().size();
        Assert.assertEquals(expectedParagraphCount, result);
    }

}
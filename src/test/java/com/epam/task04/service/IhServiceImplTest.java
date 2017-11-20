package com.epam.task04.service;

import com.epam.task04.entity.Component;
import org.junit.Assert;
import org.junit.Test;


public class IhServiceImplTest {
    IhService ihService = new IhServiceImpl();

    @Test
    public void shouldReturnComponentWithFourParagraphesWhenExecuted(){
        int inputForI = 15;
        int inputForJ = 5;
        int expectedParagraphCount = 4;
        Component component = ihService.buildTextStructure(inputForI, inputForJ);
        int result = component.getComponents().size();
        Assert.assertEquals(expectedParagraphCount, result);
    }

}
package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentencesHandlerTest {
    SentencesHandler sentencesHandler = new SentencesHandler();
    @Test
    public void shouldReturnComponentWithEmptyComponentsListWhenHaveNoSuccessor() {
        String inputTextString = "Mocking is a testing. Technique NUMBER i--+5-++j.\nWidely used not only in Java.\n" +
                "But in any other object. Oriented programming language.";
        int inputForI = 100;
        int inputForJ = 103;
        int expected = 0;

        Component component = sentencesHandler.handleRequest(inputTextString, inputForI, inputForJ);
        int result = component.getComponents().size();
        Assert.assertEquals(expected, result);

    }

}
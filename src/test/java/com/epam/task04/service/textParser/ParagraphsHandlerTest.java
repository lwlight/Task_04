package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParagraphsHandlerTest {
    private ParagraphsHandler paragraphsHandler = new ParagraphsHandler();
    private SentencesHandler sentencesHandler = new SentencesHandler();
    private LexemesHandler lexemesHandler = new LexemesHandler();
    {
        paragraphsHandler.setSuccessor(sentencesHandler);
        sentencesHandler.setSuccessor(lexemesHandler);
    }

    @Test
    public void shouldReturnComponentWithThreeParagraphesWhenExecuted(){
        String inputTextString = "Mocking is a testing technique NUMBER i--+5-++j.\nWidely used not only in Java.\n" +
                "But in any other object oriented programming language.";
        int inputForI = 100;
        int inputForJ = 103;
        int expectedParagraphCount = 3;
        Component component = paragraphsHandler.handleRequest(inputTextString, inputForI, inputForJ);
        int result = component.getComponents().size();
        Assert.assertEquals(expectedParagraphCount, result);
    }

}
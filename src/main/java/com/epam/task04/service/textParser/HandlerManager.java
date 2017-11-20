package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;


public final class HandlerManager {
    private final static HandlerManager instance = new HandlerManager();
    private ParagraphsHandler paragraphsHandler = new ParagraphsHandler();
    private SentencesHandler sentencesHandler = new SentencesHandler();
    private LexemesHandler lexemesHandler = new LexemesHandler();
    {
        paragraphsHandler.setSuccessor(sentencesHandler);
        sentencesHandler.setSuccessor(lexemesHandler);
    }

    private HandlerManager(){}

    public static HandlerManager getInstance(){
        return instance;
    }

    public Component buildComponent(String fullText, int valueForI, int valueForJ){
        return paragraphsHandler.handleRequest(fullText, valueForI, valueForJ);
    }
}

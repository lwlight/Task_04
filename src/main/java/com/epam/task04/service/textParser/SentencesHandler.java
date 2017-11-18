package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import com.epam.task04.entity.Composite;

/**
 * Created by lwLight on 10.11.2017.
 */
public class SentencesHandler extends Handler{
    @Override
    public Component handleRequest(String text, int valueForI, int valueForJ) {
        Component composite = new Composite();

        if (successor != null){
            String[] sentences = getSentences(text);
            int sentenceLength = sentences.length;
            for(int i=0; i<sentenceLength; i++){
                String sentenceText = sentences[i];
                Component innerEntity = successor.handleRequest(sentenceText, valueForI, valueForJ);
                composite.addComponent(innerEntity);
            }
        }

        return composite;
    }

    private String[] getSentences(String text){
        String textWithSeparators = text.replace(". ", ".");
        textWithSeparators = textWithSeparators.replace(".", ".!!!");
        String[] splitedTest = textWithSeparators.split("!!!");
        return splitedTest;
    }
}

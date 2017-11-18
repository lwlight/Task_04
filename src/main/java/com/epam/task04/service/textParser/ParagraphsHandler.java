package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;
import com.epam.task04.entity.Composite;

/**
 * Created by lwLight on 10.11.2017.
 */
public class ParagraphsHandler extends Handler {
    @Override
    public Component handleRequest(String text, int valueForI, int valueForJ) {
        Component composite = new Composite();

        if (successor != null){
            String[] paragraphs = getParagraphs(text);
            int paragraphLength = paragraphs.length;
            for(int i=0; i<paragraphLength; i++){
                String paragraphText = paragraphs[i];
                Component innerEntity = successor.handleRequest(paragraphText, valueForI, valueForJ);
                composite.addComponent(innerEntity);
            }
        }

        return composite;
    }

    private String[] getParagraphs(String text){
        return text.split("\\n");
    }
}

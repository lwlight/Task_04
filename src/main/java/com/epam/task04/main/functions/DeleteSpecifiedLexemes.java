package com.epam.task04.main.functions;

import com.epam.task04.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteSpecifiedLexemes {
    private static final Logger LOGGER = LogManager.getLogger(DeleteSpecifiedLexemes.class.getName());

    public Component removeSpecifiedLexemes(Component originalComponent, int lexemeLength, String lexemeStartsWith ) {

        if (originalComponent == null) {
            LOGGER.error("Corrupted component structure");
            return null;
        }

        Component parsedComponent = parseComponent(originalComponent, lexemeLength, lexemeStartsWith);

        return parsedComponent;
    }


    private Component parseComponent(Component component,  int lexemeLength, String lexemeStartsWith){

        List<Component> paragraphsList = component.getComponents();

        Iterator<Component> paragraphIterator = paragraphsList.iterator();

        while (paragraphIterator.hasNext()){
            Component paragraph = paragraphIterator.next();

            List<Component> sentenceList = paragraph.getComponents();

            Iterator<Component> sentenceIterator = sentenceList.iterator();

            while (sentenceIterator.hasNext()){
                Component sentence = sentenceIterator.next();

                List<Component> lexemesList = sentence.getComponents();
                List<Component> lexemesForDelete = new ArrayList<>();

                Iterator<Component> lexemeIterator = lexemesList.iterator();

                while (lexemeIterator.hasNext()){
                    Component lexeme = lexemeIterator.next();
                    String value = lexeme.getValue();
                    boolean isMatch = checkForMatch(value, lexemeLength, lexemeStartsWith);
                    if (isMatch){
                        lexemesForDelete.add(lexeme);
                    }
                }

                deleteMatchedComponents(sentence, lexemesForDelete);
            }
        }
        return component;
    }

    private boolean checkForMatch(String value, int lexemeLength, String lexemeStartsWith){
        int valueLength = value.length();
        if (valueLength != lexemeLength){
            return false;
        }
        return value.startsWith(lexemeStartsWith);
    }

    private void deleteMatchedComponents(Component sentence, List<Component> lexemesForDelete){
        for (Component lexeme : lexemesForDelete){
            LOGGER.debug("Lexeme \"" + lexeme.getValue() + "\" has been deleted!" );
            sentence.removeComponent(lexeme);
        }
    }

}

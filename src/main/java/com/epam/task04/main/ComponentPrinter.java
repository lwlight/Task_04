package com.epam.task04.main;

import com.epam.task04.entity.Component;
import com.epam.task04.entity.PunctuationTerminalComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ComponentPrinter {
    private static final Logger LOGGER = LogManager.getLogger(ComponentPrinter.class.getName());

    public String parseTextFromComponent(Component component){
        if (component == null) {
            LOGGER.error("Corrupted component structure");
            return null;
        }

        String result = parseComponent(component);

        LOGGER.info(result);
        return result;
    }

    private String parseComponent(Component component){
        String result = "";
        List<Component> paragraphsList = component.getComponents();

        for (Component paragraph : paragraphsList) {
            result += "\n";

            List<Component> sentencesList = paragraph.getComponents();
            for (Component sentence : sentencesList) {

                List<Component> lexemesList = sentence.getComponents();
                result += addLexeme(lexemesList);
            }
        }

        result = processResultString(result);
        return result;
    }

    private String addLexeme(List<Component> lexemesList){
        String resultWithLexeme = "";
        for (Component lexeme : lexemesList) {

            if (lexeme instanceof PunctuationTerminalComponent) {
                resultWithLexeme += lexeme.getValue();
            } else {
                resultWithLexeme += " " + lexeme.getValue();
            }
        }

        return resultWithLexeme;
    }

    private String processResultString(String toProcess){
        String result = toProcess.trim();
        if (result.startsWith("\n")){
            int indexOfStringShiftSymbol = result.indexOf("\n");
            result = result.substring(indexOfStringShiftSymbol);
        }
        return result;
    }
}

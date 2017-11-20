package com.epam.task04.service.mathInterpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpressionFormatter {
    private static final Logger LOGGER = LogManager.getLogger(ExpressionFormatter.class.getName());

    private static final ExpressionFormatter instance = new ExpressionFormatter();
    private ExpressionFormatter(){}
    public static ExpressionFormatter getInstance(){
        return instance;
    }


    public String formateMathExpression(String mathExpression, int valueForI, int valueForJ){
        String formated = mathExpression;
        formated = editValuesForVariables(formated, valueForI, valueForJ);
        formated = addSeparators(formated);

        return formated;
    }

    private String editValuesForVariables(String expressionToEdit , int valueForI, int valueForJ){
        String editedExpression = expressionToEdit;
        String incrementedI = (valueForI + 1) + "";
        String decrementedI = (valueForI - 1) + "";
        String incrementedJ = (valueForJ + 1) + "";
        String decrementedJ = (valueForJ - 1) + "";
        String valueI = valueForI + "";
        String valueJ = valueForJ + "";

        editedExpression = editedExpression.replace("++i", incrementedI);
        editedExpression = editedExpression.replace("i++", incrementedI);
        editedExpression = editedExpression.replace("--i", decrementedI);
        editedExpression = editedExpression.replace("i--", decrementedI);
        editedExpression = editedExpression.replace("++j", incrementedJ);
        editedExpression = editedExpression.replace("j++", incrementedJ);
        editedExpression = editedExpression.replace("--j", decrementedJ);
        editedExpression = editedExpression.replace("j--", decrementedJ);
        editedExpression = editedExpression.replace("i", valueI);
        editedExpression = editedExpression.replace("j", valueJ);

        return editedExpression;
    }

    private String addSeparators(String expressionToParse){
        String separated = expressionToParse;

        separated = separated.replace("(", " ( ");
        separated = separated.replace(")", " ) ");
        separated = separated.replace("+", " + ");
        separated = separated.replace("-", " - ");
        separated = separated.replace("=", " = ");
        separated = separated.replace("*", " * ");
        separated = separated.replace("/", " / ");
        separated = separated.replace("  ", " ");

        return separated.trim();
    }
}

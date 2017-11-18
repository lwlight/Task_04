package com.epam.task04.service.mathInterpreter;

public class ExpressionFormatter {
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
        editedExpression = editedExpression.replace("++i", valueForI+1+"");
        editedExpression = editedExpression.replace("i++", valueForI+1+"");
        editedExpression = editedExpression.replace("--i", valueForI-1+"");
        editedExpression = editedExpression.replace("i--", valueForI-1+"");
        editedExpression = editedExpression.replace("++j", valueForI+1+"");
        editedExpression = editedExpression.replace("j++", valueForI+1+"");
        editedExpression = editedExpression.replace("--j", valueForI-1+"");
        editedExpression = editedExpression.replace("j--", valueForI-1+"");
        editedExpression = editedExpression.replace("i", valueForI+"");
        editedExpression = editedExpression.replace("j", valueForJ+"");
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

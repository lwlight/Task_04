package com.epam.task04.service.textParser;

import com.epam.task04.entity.*;
import com.epam.task04.service.mathInterpreter.ConvertInfixToRPN;
import com.epam.task04.service.mathInterpreter.ExpressionFormatter;
import com.epam.task04.service.mathInterpreter.InterpreterClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemesHandler extends Handler {
    @Override
    public Component handleRequest(String text, int valueForI, int valueForJ) {
        Component composite = new Composite();

        String[] lexemes = parseLexemes(text);
        int lexemesLength = lexemes.length;

        for (int i = 0; i < lexemesLength; i++) {
            String lexeme = lexemes[i];
            if (isMathExpression(lexeme)){
                MathExpTerminalComponent terminalComponent = buildMathComponent(lexeme, valueForI, valueForJ);
                composite.addComponent(terminalComponent);
            } else if (isPunctuationSymbol(lexeme)) {
                PunctuationTerminalComponent terminalComponent = new PunctuationTerminalComponent();
                terminalComponent.setValue(lexeme);
                composite.addComponent(terminalComponent);
            } else {
                WordTerminalComponent terminalComponent = new WordTerminalComponent();
                terminalComponent.setValue(lexeme);
                composite.addComponent(terminalComponent);
            }
        }

        return composite;
    }

    private MathExpTerminalComponent buildMathComponent(String lexeme, int valueForI, int valueForJ){

        ExpressionFormatter formatter = ExpressionFormatter.getInstance();
        String formattedLexeme = formatter.formateMathExpression(lexeme, valueForI, valueForJ);
        System.out.println("LexemesHandler : lexeme => " + lexeme );
        System.out.println("LexemesHandler : BuildMathComponent => " + formattedLexeme);

        String reversePolishNotation = new ConvertInfixToRPN().convertInfixToRPN(formattedLexeme);

        InterpreterClient interpreterClient = InterpreterClient.getInstance();
        String lexemeExpressionResult = interpreterClient.calculate(reversePolishNotation);

        MathExpTerminalComponent terminalComponent = new MathExpTerminalComponent();
        terminalComponent.setValue(lexemeExpressionResult);

        return terminalComponent;
    }


    private boolean isMathExpression(String lexeme){
        Pattern pattern = Pattern.compile("[0-9]+(-|\\+|\\*|\\/){1}");
        Matcher matcher = pattern.matcher(lexeme);

        return matcher.find();
    }
    private boolean isPunctuationSymbol(String lexeme){
        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(lexeme);

        return matcher.find();
    }

    private String[] parseLexemes(String text){
        String sentence = text;
        sentence = sentence.replace(", ", " , ");
        sentence = sentence.replace("; ", " ; ");
        sentence = sentence.replace(".", " . ");
        sentence = sentence.replace("  ", " ");
        String[] splitedSentence = sentence.split(" ");
        return splitedSentence;
    }


}

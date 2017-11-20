package com.epam.task04.service.textParser;

import com.epam.task04.entity.*;
import com.epam.task04.service.mathInterpreter.ConvertInfixToRpn;
import com.epam.task04.service.mathInterpreter.ExpressionFormatter;
import com.epam.task04.service.mathInterpreter.InterpreterClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemesHandler extends Handler {
    private static final Logger LOGGER = LogManager.getLogger(LexemesHandler.class.getName());

    public static final String MATH_EXPRESSION = "[0-9]+(-|\\+|\\*|\\/){1}";
    public static final String PUNCTUATION_SYMBOL = "[\\.!,;:?]{1}";

    @Override
    public Component handleRequest(String text, int valueForI, int valueForJ) {
        Component composite = new Composite();

        String[] lexemes = parseLexemes(text);
        int lexemesLength = lexemes.length;

        for (int i = 0; i < lexemesLength; i++) {
            String lexeme = lexemes[i];
            if (isMathExpression(lexeme)) {
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

        String reversePolishNotation = new ConvertInfixToRpn().convertInfixToRPN(formattedLexeme);

        InterpreterClient interpreterClient = InterpreterClient.getInstance();
        String lexemeExpressionResult = interpreterClient.calculate(reversePolishNotation);

        MathExpTerminalComponent terminalComponent = new MathExpTerminalComponent();
        terminalComponent.setValue(lexemeExpressionResult);

        return terminalComponent;
    }


    private boolean isMathExpression(String lexeme){
        Pattern pattern = Pattern.compile(MATH_EXPRESSION);
        Matcher matcher = pattern.matcher(lexeme);

        return matcher.find();
    }
    private boolean isPunctuationSymbol(String lexeme){
        Pattern pattern = Pattern.compile(PUNCTUATION_SYMBOL);
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

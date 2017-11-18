package com.epam.task04.service.mathInterpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwLight on 11.11.2017.
 */
public class InterpreterClient {
    private static final InterpreterClient instance = new InterpreterClient();

    private List<AbstractMathExpression> listExpression = new ArrayList<>();

    private InterpreterClient(){}

    public static InterpreterClient getInstance(){

        return instance;
    }

    public String calculate(String expression){
        parse(expression);
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression){
            terminal.interpret(context);
        }
        Number result = context.popValue();
        return result.toString();
    }

    private void parse(String expression){
        for (String lexeme : expression.split("\\p{Blank}+")){
            System.out.println("InterpreterClient : parse => " + lexeme);
            if (lexeme.isEmpty()){
                continue;
            }

            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if(scan.hasNextInt()){
                        listExpression.add(new NonterminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

}

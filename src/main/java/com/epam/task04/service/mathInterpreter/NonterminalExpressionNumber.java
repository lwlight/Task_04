package com.epam.task04.service.mathInterpreter;

/**
 * Created by lwLight on 11.11.2017.
 */
public class NonterminalExpressionNumber  implements AbstractMathExpression{
    private int number;
    public NonterminalExpressionNumber(int number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}

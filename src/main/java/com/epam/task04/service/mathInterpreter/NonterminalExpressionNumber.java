package com.epam.task04.service.mathInterpreter;


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

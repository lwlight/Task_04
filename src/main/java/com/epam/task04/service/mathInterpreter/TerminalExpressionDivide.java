package com.epam.task04.service.mathInterpreter;


public class TerminalExpressionDivide implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue((context.popValue() / context.popValue()));
    }
}

package com.epam.task04.service.mathInterpreter;

/**
 * Created by lwLight on 11.11.2017.
 */
public class TerminalExpressionMinus implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() - context.popValue());
    }
}

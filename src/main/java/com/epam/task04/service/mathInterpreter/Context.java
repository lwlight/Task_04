package com.epam.task04.service.mathInterpreter;

import java.util.ArrayDeque;

/**
 * Created by lwLight on 11.11.2017.
 */
public class Context {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();
    public Integer popValue(){
        return contextValues.pop();
    }
    public void pushValue(Integer value){
        this.contextValues.push(value);
    }
}

package com.epam.task04.service.mathInterpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ConvertInfixToRpn {
    private static final Logger LOGGER = LogManager.getLogger(ConvertInfixToRpn.class.getName());

    public String convertInfixToRPN(String infixNotation) {
        LOGGER.debug("Infix notation entred: " + infixNotation);

        String[] infixMass = infixNotation.split(" ");

        Map<String, Integer> prededence = new HashMap<>();
        prededence.put("/", 5);
        prededence.put("*", 5);
        prededence.put("+", 4);
        prededence.put("-", 4);
        prededence.put("(", 0);

        String result = "";

        Queue<String> infixNotationList = new LinkedList<>();
        Stack<String> operatorsStack = new Stack<>();

        for (String token : infixMass) {
            if ("(".equals(token)) {
                operatorsStack.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(operatorsStack.peek())) {
                    infixNotationList.add(operatorsStack.pop());
                }
                operatorsStack.pop();
                continue;
            }

            if (prededence.containsKey(token)) {
                while (!operatorsStack.empty() && prededence.get(token) <= prededence.get(operatorsStack.peek())) {
                    infixNotationList.add(operatorsStack.pop());
                }
                operatorsStack.push(token);
                continue;
            }

            if (isNumber(token)) {
                infixNotationList.add(token);
                continue;
            }

            throw new IllegalArgumentException("Invalid input");
        }

        while (!operatorsStack.isEmpty()) {
            infixNotationList.add(operatorsStack.pop());
        }

        for (String element : infixNotationList){
            result += element + " ";
        }

        LOGGER.debug("Convert result: " + result);

        return result.trim();
    }

    private boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}

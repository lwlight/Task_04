package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;


public abstract class Handler {
    protected Handler successor;

    public abstract Component handleRequest(String text, int valueForI, int ValueForJ);

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

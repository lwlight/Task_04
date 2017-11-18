package com.epam.task04.service.textParser;

import com.epam.task04.entity.Component;

/**
 * Created by lwLight on 10.11.2017.
 */
public abstract class Handler {
    protected Handler successor;

    public abstract Component handleRequest(String text, int valueForI, int ValueForJ);

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

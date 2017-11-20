package com.epam.task04.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private List<Component> sentenceComponents = new ArrayList<>();


    public Composite(){}


    @Override
    public void addComponent(Component component) {
        sentenceComponents.add(component);
    }

    @Override
    public List getComponents() {
        return sentenceComponents;
    }

    @Override
    public void setComponents(List<Component> components) {
        sentenceComponents = components;
    }

    @Override
    public void removeComponent(Component component) {
        sentenceComponents.remove(component);
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }
}

package com.epam.task04.entity;

import java.util.List;

public class MathExpTerminalComponent implements Component {
    private String value;

    public MathExpTerminalComponent(){}

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setComponents(List<Component> components) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}

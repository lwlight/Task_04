package com.epam.task04.entity;

import java.util.List;

public interface Component {
    void addComponent(Component component);

    List getComponents();

    void setComponents(List<Component> components);

    void removeComponent(Component component);

    void setValue(String value);

    String getValue();
}

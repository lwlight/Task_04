package com.epam.task04.main;

import com.epam.task04.dao.IHDAO;
import com.epam.task04.dao.IHDAOImpl;
import com.epam.task04.entity.Component;
import com.epam.task04.service.IHService;
import com.epam.task04.service.ServiceFactory;

public class Main {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IHService ihService = serviceFactory.getIHService();
        Component component = ihService.buildTextStructure(1, 2);

        System.out.println(component);

    }
}

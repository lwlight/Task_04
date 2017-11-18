package com.epam.task04.service;

import com.epam.task04.dao.DAOFactory;
import com.epam.task04.dao.IHDAO;
import com.epam.task04.entity.Component;
import com.epam.task04.service.textParser.Handler;
import com.epam.task04.service.textParser.HandlerManager;
import com.epam.task04.service.textParser.ParagraphsHandler;

public class IHServiceImpl implements IHService {
    @Override
    public Component buildTextStructure(int valueForI, int valueForJ) {
        DAOFactory daoFactory = DAOFactory.getInstatnce();
        IHDAO ihdao = daoFactory.getIHDAO();
        String fullTextValue = ihdao.readFullTextValue();
//        Handler handler = new ParagraphsHandler();
//        Component component = handler.handleRequest(fullTextValue);
        HandlerManager handlerManager = HandlerManager.getInstance();
        Component component = handlerManager.buildComponent(fullTextValue, valueForI, valueForJ);



        return component;
    }
}

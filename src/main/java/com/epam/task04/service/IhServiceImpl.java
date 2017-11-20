package com.epam.task04.service;

import com.epam.task04.dao.DaoFactory;
import com.epam.task04.dao.IhDao;
import com.epam.task04.entity.Component;
import com.epam.task04.service.textParser.HandlerManager;

public class IhServiceImpl implements IhService {
    @Override
    public Component buildTextStructure(int valueForI, int valueForJ) {
        DaoFactory daoFactory = DaoFactory.getInstatnce();
        IhDao ihDao = daoFactory.getIHDAO();
        String fullTextValue = ihDao.readFullTextValue();
        HandlerManager handlerManager = HandlerManager.getInstance();

        Component component = handlerManager.buildComponent(fullTextValue, valueForI, valueForJ);

        return component;
    }
}

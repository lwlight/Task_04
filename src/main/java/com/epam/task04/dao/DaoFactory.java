package com.epam.task04.dao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final IhDao ihDao = new IhDaoImpl();

    private DaoFactory(){
    }

    public static DaoFactory getInstatnce() {
        return instance;
    }

    public IhDao getIHDAO(){
        return ihDao;
    }

}

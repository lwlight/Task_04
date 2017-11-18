package com.epam.task04.dao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final IHDAO ihdao = new IHDAOImpl();

    private DAOFactory(){
    }

    public static DAOFactory getInstatnce() {
        return instance;
    }

    public IHDAO getIHDAO(){
        return ihdao;
    }

}

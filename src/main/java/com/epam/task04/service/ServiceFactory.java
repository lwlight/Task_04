package com.epam.task04.service;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final IhService ihService = new IhServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public IhService getIHService() {
        return ihService;
    }
}

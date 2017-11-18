package com.epam.task04.service;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final IHService ihService = new IHServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public IHService getIHService() {
        return ihService;
    }
}

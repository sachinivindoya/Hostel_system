package lk.D24.service;

import lk.D24.service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public ServiceFactory(){

    }
    public static ServiceFactory getInstance(){
        return serviceFactory==null ? (serviceFactory=new ServiceFactory()): serviceFactory;
    }
    public  <T extends SuperService>T getService(ServiceType serviceType) {
        switch (serviceType) {
            case STUDENT:
                return (T) new StudentServiceImpl();

            default:
                return null;
        }
    }
}

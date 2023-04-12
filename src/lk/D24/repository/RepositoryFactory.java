package lk.D24.repository;

import lk.D24.repository.custom.impl.StudentRepositoryImpl;

public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }


    public static RepositoryFactory getInstance() {
        return repositoryFactory == null ? (repositoryFactory = new RepositoryFactory()) : repositoryFactory;
    }

    public <T extends SuperRepository> T getRepository(RepositoryType repositoryType) {
        switch (repositoryType) {
            case STUDENT:
                return (T) new StudentRepositoryImpl();

            default:
                return null;
        }
    }
}


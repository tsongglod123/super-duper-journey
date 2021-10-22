package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class EntityManagerService {
    private static final String UNIT_NAME = "classic-model";

    static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
        return emf.createEntityManager();
    }
}

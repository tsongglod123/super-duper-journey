package sit.int202.classicmodelweb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Office;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        int pk = 1;
        while (true) {
            Office office = manager.find(Office.class, Integer.toString(pk));
            if (office == null) {
                break;
            } else {
                System.out.println(office);
                ++pk;
            }
        }
    }
}

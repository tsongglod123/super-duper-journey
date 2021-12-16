package int202.practice.test;

import int202.practice.test.entities.Employee;
import int202.practice.test.entities.Office;
import int202.practice.test.repo.EmpRepo;
import int202.practice.test.repo.OfficeRepo;

public class Main {
    public static void main(String[] args) {
        EmpRepo empRepo = new EmpRepo();
        System.out.println(empRepo.find(1002));

        for (Employee emp : empRepo.findAll()) {
            System.out.println(emp);
        }

        for (Employee emp : empRepo.findByOfficeId(1)) {
            System.out.println(emp);
        }

        OfficeRepo officeRepo = new OfficeRepo();
        System.out.println(officeRepo.find(1));

        for (Office office : officeRepo.findAll()) {
            System.out.println(office);
        }
    }
}

package sit.int202.classicmodelweb;

import sit.int202.classicmodelweb.entities.Employee;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.EmpRepo;
import sit.int202.classicmodelweb.repositories.OfficeRepo;

public class Main {
    public static void main(String[] args) {
        OfficeRepo officeRepo = new OfficeRepo();
        EmpRepo empRepo = new EmpRepo();

//        Office newOff = new Office();
//        newOff.setId("8");
//        newOff.setCity("New Asgard");
//        newOff.setCountry("Midgard");
//        newOff.setAddressLine1("somewhere");
//        newOff.setPhone("+69 1234 5678");
//        newOff.setTerritory("THOR");
//        newOff.setPostalCode("420420");
//        officeRepo.save(newOff);

        for (Office office : officeRepo.findAll()) {
            System.out.println(office.getId() + ": " + office.getCity());
            office.getEmployeeList().forEach(Main::printEmp);
        }
        System.out.println();

        empRepo.findByDesc("M").forEach(Main::printEmp);
        System.out.println(empRepo.find(1056));
    }

    private static void printEmp(Employee e) {
        System.out.printf("%7d %-10s %-15s %-20s %s\n", e.getId(), e.getFirstName(),
                e.getLastName(), e.getJobTitle(), e.getEmail());
    }

}

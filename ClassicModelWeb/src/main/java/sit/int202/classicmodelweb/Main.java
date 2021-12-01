package sit.int202.classicmodelweb;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Employee;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.CustomerRepo;
import sit.int202.classicmodelweb.repositories.EmpRepo;
import sit.int202.classicmodelweb.repositories.OfficeRepo;
import sit.int202.classicmodelweb.repositories.ProductRepo;

public class Main {
    public static void main(String[] args) {
        String password = "test";

        CustomerRepo cr = new CustomerRepo();
        Customer customer = cr.findByName("Young Mary");
        System.out.println(customer);

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
        System.out.println(result.toString());
        System.out.println(result.validFormat);
        System.out.println(result.verified);
//        OfficeRepo officeRepo = new OfficeRepo();
//        EmpRepo empRepo = new EmpRepo();
//        ProductRepo productRepo = new ProductRepo();
//        System.out.println(productRepo.findAll(1, 5));
//        System.out.println(productRepo.countAll());

//        Office newOff = new Office();
//        newOff.setId("8");
//        newOff.setCity("New Asgard");
//        newOff.setCountry("Midgard");
//        newOff.setAddressLine1("somewhere");
//        newOff.setPhone("+69 1234 5678");
//        newOff.setTerritory("THOR");
//        newOff.setPostalCode("420420");
//        officeRepo.save(newOff);

//        Office oldOffice =  officeRepo.find("8");
//        oldOffice.setPostalCode("123456");
//        officeRepo.update(oldOffice);

//        for (Office office : officeRepo.findAll()) {
//            System.out.println(office.getId() + ": " + office.getCity());
//            office.getEmployeeList().forEach(Main::printEmp);
//        }
//        System.out.println();

//        empRepo.findByDesc("M").forEach(Main::printEmp);
//        System.out.println(empRepo.find(1056));
    }

    private static void printEmp(Employee e) {
        System.out.printf("%7d %-10s %-15s %-20s %s\n", e.getId(), e.getFirstName(),
                e.getLastName(), e.getJobTitle(), e.getEmail());
    }

}

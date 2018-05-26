package repository;

import app.Utils;
import models.Customer;
import models.PhoneNumber;

import java.util.*;

/**
 * Created by diogo on 25/05/2018.
 */
public class Persistence implements IPersistence{

    private static HashMap<Integer, Customer> customers;
    private static HashMap<String, PhoneNumber> phoneNumbers;

    static {
        customers = new HashMap<>();
        phoneNumbers = new HashMap<>();

        Customer c1 = new Customer(1, "John");
        PhoneNumber p1c1 = new PhoneNumber("071213221341", c1, true);
        PhoneNumber p2c1 = new PhoneNumber("0712222111342", c1, true);
        PhoneNumber p3c1 = new PhoneNumber("0712131321343", c1, true);
        PhoneNumber p4c1 = new PhoneNumber("07121323221344", c1, true);
        c1.setPhoneNumbers(Utils.addAll(p1c1, p2c1, p3c1, p4c1));


        Customer c2 = new Customer(2, "David");
        PhoneNumber p1c2 = new PhoneNumber("081213221345", c2, true);
        PhoneNumber p2c2 = new PhoneNumber("0812222111346", c2, true);
        PhoneNumber p3c2 = new PhoneNumber("0812131321347", c2, true);
        PhoneNumber p4c2 = new PhoneNumber("08121323221348", c2, true);
        c2.setPhoneNumbers(Utils.addAll(p1c2, p2c2, p3c2, p4c2));


        Customer c3 = new Customer(3, "Andrew");
        PhoneNumber p1c3 = new PhoneNumber("081213221349", c3, true);
        PhoneNumber p2c3 = new PhoneNumber("0812222111310", c3, true);
        PhoneNumber p3c3 = new PhoneNumber("0812131321311", c3, true);
        PhoneNumber p4c3 = new PhoneNumber("08121323221312", c3, true);
        c3.setPhoneNumbers(Utils.addAll(p1c3, p2c3, p3c3, p4c3));

        Customer c4 = new Customer(4, "Diogo");
        PhoneNumber p1c4 = new PhoneNumber("081213221313", c4, true);
        PhoneNumber p2c4 = new PhoneNumber("0812222111314", c4, true);
        PhoneNumber p3c4 = new PhoneNumber("0812131321315", c4, true);
        PhoneNumber p4c4 = new PhoneNumber("08121323221316", c4, true);
        c4.setPhoneNumbers(Utils.addAll(p1c4, p2c4, p3c4, p4c4));

        Customer c5 = new Customer(5, "Peter");
        PhoneNumber p1c5 = new PhoneNumber("081213221317", c5, true);
        PhoneNumber p2c5 = new PhoneNumber("0812222111318", c5, true);
        PhoneNumber p3c5 = new PhoneNumber("0812131321319", c5, true);
        PhoneNumber p4c5 = new PhoneNumber("08121323221320", c5, true);
        c5.setPhoneNumbers(Utils.addAll(p1c5, p2c5, p3c5, p4c5));


        Customer c6 = new Customer(6, "Matt");
        PhoneNumber p1c6 = new PhoneNumber("081213221321", c6, true);
        PhoneNumber p2c6 = new PhoneNumber("0812222111322", c6, true);
        PhoneNumber p3c6 = new PhoneNumber("0812131321323", c6, true);
        PhoneNumber p4c6 = new PhoneNumber("08121323221324", c6, true);
        c6.setPhoneNumbers(Utils.addAll(p1c6, p2c6, p3c6, p4c6));

        customers.put(1, c1);
        customers.put(2, c2);
        customers.put(3, c3);
        customers.put(4, c4);
        customers.put(5, c5);
        customers.put(6, c6);

        for (Map.Entry<Integer, Customer> customerSet : customers.entrySet()) {
            List<PhoneNumber> numbers = customerSet.getValue().getPhoneNumbers();
            for (PhoneNumber phNumber : numbers) {
                phoneNumbers.put(phNumber.getNumber(), phNumber);
            }
        }
    }

    /*public boolean addPhoneNumber( int customerId, String number, boolean activated ) {
        if( phoneNumbers.get(number) != null ) {
            return false;
        }

        Customer customer = customers.get(customerId);
        PhoneNumber ph = new PhoneNumber(number, customer, activated );

        customers.get(customerId).getPhoneNumbers().add(ph);
        phoneNumbers.put(number, ph);
        return true;
    } */

    public boolean existsCustomer(int cst) {
        return customers.containsKey(cst);
    }

    public boolean existsPhoneNumber(String cst) {
        return phoneNumbers.containsKey(cst);
    }

    public Collection<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumbers.values();
    }

    public boolean activatePhoneNumber(String number) {
        phoneNumbers.get(number).setActivated(true);
        return true;
    }

    public Collection<PhoneNumber> getPhoneNumbersOfCustomer(int i) {
        return customers.get(i).getPhoneNumbers();
    }

}

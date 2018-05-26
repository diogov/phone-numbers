import app.Utils;
import models.Customer;
import models.PhoneNumber;
import repository.IPersistence;
import java.util.*;

/**
 * Created by diogo on 26/05/2018.
 */
public class PersistenceSuccessMock implements IPersistence {

    public boolean existsCustomer(int cst) {
        return true;
    }

    public boolean existsPhoneNumber(String phn) {
        return true;
    }

    public Collection<PhoneNumber> getAllPhoneNumbers() {
        Customer c1 = new Customer(1, "John");
        PhoneNumber ph1 = new PhoneNumber("0", c1, true);
        PhoneNumber ph2 = new PhoneNumber("1", c1, true);

        Customer c2 = new Customer(2, "Diogo");
        PhoneNumber ph3 = new PhoneNumber("2", c2, true);
        PhoneNumber ph4 = new PhoneNumber("3", c2, false);
        PhoneNumber ph5 = new PhoneNumber("4", c2, true);

        return Utils.addAll(ph1, ph2, ph3, ph4, ph5);
    }

    public boolean activatePhoneNumber(String number) {
        return true;
    }

    public Collection<PhoneNumber> getPhoneNumbersOfCustomer(int i) {
        Customer c1 = new Customer(1, "John");
        PhoneNumber ph1 = new PhoneNumber("0", c1, true);
        PhoneNumber ph2 = new PhoneNumber("1", c1, true);
        return Utils.addAll(ph1, ph2);
    }
}

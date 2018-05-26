import models.PhoneNumber;
import repository.IPersistence;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by diogo on 26/05/2018.
 */
public class PersistenceFailMock implements IPersistence {
    @Override
    public boolean existsCustomer(int cst) {
        return false;
    }

    @Override
    public boolean existsPhoneNumber(String cst) {
        return false;
    }

    @Override
    public Collection<PhoneNumber> getAllPhoneNumbers() {
        return new LinkedList<>();
    }

    @Override
    public boolean activatePhoneNumber(String number) {
        return false;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbersOfCustomer(int i) {
        return null;
    }
}

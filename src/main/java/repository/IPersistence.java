package repository;

import models.PhoneNumber;

import java.util.Collection;

/**
 * Created by diogo on 26/05/2018.
 */
public interface IPersistence {

    boolean existsCustomer(int cst);

    boolean existsPhoneNumber(String cst);

    Collection<PhoneNumber> getAllPhoneNumbers();

    boolean activatePhoneNumber(String number);

    Collection<PhoneNumber> getPhoneNumbersOfCustomer(int i);
}

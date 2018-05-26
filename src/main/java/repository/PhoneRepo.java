package repository;

import models.PhoneNumber;

import java.util.*;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneRepo {

    private IPersistence persistence;

    public PhoneRepo(IPersistence persistence) {
        this.persistence = persistence;
    }

    public Collection<PhoneNumber> getAllPhoneNumbers() {

        return persistence.getAllPhoneNumbers();
    }

    public Collection<PhoneNumber> getCustomerPhoneNumbers(int i) {
        return persistence.getPhoneNumbersOfCustomer(i);
    }

    public void activate(String number) {
        persistence.activatePhoneNumber(number);
    }

    public boolean existsCustomer(int cst) {
        return persistence.existsCustomer(cst);
    }

    public boolean existsPhoneNumber(String phoneNumber) {
        return persistence.existsPhoneNumber(phoneNumber);
    }
}

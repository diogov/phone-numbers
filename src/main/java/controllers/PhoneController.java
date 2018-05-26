package controllers;

import models.PhoneNumber;
import repository.PhoneRepo;
import views.PhoneNumberView;
import views.PhoneNumberSimpleView;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneController {

    private PhoneRepo phoneRepo;

    public PhoneController(PhoneRepo repo) {
        this.phoneRepo = repo;
    }


    public List<PhoneNumberView> getAllPhoneNumbers() {
        Collection<PhoneNumber> numbers = phoneRepo.getAllPhoneNumbers();

        //mapping
        List<PhoneNumberView> listView = new LinkedList<>();
        for( PhoneNumber nbr : numbers ) {
            PhoneNumberView view = new PhoneNumberView();
            view.setNumber(  nbr.getNumber() );
            view.setCustomerId( nbr.getCustomer().getId() );
            view.setCustomerName( nbr.getCustomer().getName() );
            view.setActivated( nbr.isActivated() );
            listView.add(view);
        }
        return listView;
    }

    public List<PhoneNumberSimpleView> getPhoneNumberByCustomer(int id) {
        if( !phoneRepo.existsCustomer(id) ) {
            return null;
        }

        Collection<PhoneNumber> numbers = phoneRepo.getCustomerPhoneNumbers(id);

        //mapping
        List<PhoneNumberSimpleView> listView = new LinkedList<>();
        for( PhoneNumber nbr : numbers ) {
            PhoneNumberSimpleView view = new PhoneNumberSimpleView();
            view.setNumber(  nbr.getNumber() );
            view.setActivated( nbr.isActivated() );
            listView.add(view);
        }
        return listView;
    }


    public boolean phoneActivate(String number) {
        if( !phoneRepo.existsPhoneNumber(number) ) {
            return false;
        }

        phoneRepo.activate(number);
        return true;
    }
}

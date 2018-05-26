package app;

import controllers.PhoneController;
import repository.Persistence;
import repository.PhoneRepo;

/**
 * Created by diogo on 25/05/2018.
 */
public class Main {

    public static void main(String[] args) {

        PhoneController phoneController = new PhoneController(new PhoneRepo(new Persistence()));

        PhoneRestApi phoneRestApi = new PhoneRestApi(phoneController);
        phoneRestApi.processApi();

    }

}

package models;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneNumber {

    private String number;
    private Customer customer;
    private boolean activated;

    public PhoneNumber(String number, Customer customer, boolean activated) {
        this.number = number;
        this.customer = customer;
        this.activated = activated;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}

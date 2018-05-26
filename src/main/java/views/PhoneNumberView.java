package views;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneNumberView {

    private String number;
    private Boolean activated;
    private int customerId;
    private String customerName;

    public PhoneNumberView(){

    }

    public PhoneNumberView(String number, Boolean activated, int customerId, String customerName) {
        this.number = number;
        this.activated = activated;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getActivated() {
        return activated;
    }
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customer) {
        this.customerName = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumberView that = (PhoneNumberView) o;

        if (customerId != that.customerId) return false;
        if (!number.equals(that.number)) return false;
        if (!activated.equals(that.activated)) return false;
        return customerName.equals(that.customerName);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + activated.hashCode();
        result = 31 * result + customerId;
        result = 31 * result + customerName.hashCode();
        return result;
    }
}

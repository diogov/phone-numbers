package views;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneNumberSimpleView {
    private String number;
    private Boolean activated;

    public PhoneNumberSimpleView() {
    }

    public PhoneNumberSimpleView(String number, Boolean activated) {
        this.number = number;
        this.activated = activated;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumberSimpleView that = (PhoneNumberSimpleView) o;

        if (!number.equals(that.number)) return false;
        return activated.equals(that.activated);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + activated.hashCode();
        return result;
    }
}

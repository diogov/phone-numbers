import app.Utils;
import controllers.PhoneController;
import org.junit.Before;
import org.junit.Test;
import repository.PhoneRepo;
import views.PhoneNumberSimpleView;
import views.PhoneNumberView;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.LinkedList;
import java.util.List;

public class UnitTests {

    private PhoneController phoneControllerSuccess;
    private PhoneController phoneControllerFail;

    @Before
    public void begin() throws Exception {
        PersistenceFailMock persistenceFailMock = new PersistenceFailMock();
        PersistenceSuccessMock persistenceSuccessMock = new PersistenceSuccessMock();

        phoneControllerSuccess = new PhoneController(new PhoneRepo(persistenceSuccessMock));
        phoneControllerFail = new PhoneController(new PhoneRepo(persistenceFailMock));
    }

    @Test
    public void testAllPhoneNumbersWithSuccess() {
        PhoneNumberView ph1 = new PhoneNumberView("0", true, 1, "John");
        PhoneNumberView ph2 = new PhoneNumberView("1", true, 1, "John");
        PhoneNumberView ph3 = new PhoneNumberView("2", true, 2, "Diogo");
        PhoneNumberView ph4 = new PhoneNumberView("3", false, 2, "Diogo");
        PhoneNumberView ph5 = new PhoneNumberView("4", true, 2, "Diogo");

        List<PhoneNumberView> expected = Utils.addAll(ph1, ph2, ph3, ph4, ph5);
        List<PhoneNumberView> actual = phoneControllerSuccess.getAllPhoneNumbers();

        assertThat(actual, is(expected));
    }

    @Test
    public void testAllPhoneNumbersEmptiness() {
        List<PhoneNumberSimpleView> expected = new LinkedList<>();
        List<PhoneNumberView> actual = phoneControllerFail.getAllPhoneNumbers();
        assertThat(actual, is(expected));
    }

    @Test
    public void testPhoneNumbersByCustomer() {
        PhoneNumberSimpleView view1 = new PhoneNumberSimpleView("0", true);
        PhoneNumberSimpleView view2 = new PhoneNumberSimpleView("1", true);
        List<PhoneNumberSimpleView> expected = Utils.addAll(view1, view2);

        List<PhoneNumberSimpleView> actual = phoneControllerSuccess.getPhoneNumberByCustomer(1);

        assertThat(actual, is(expected));
    }

    @Test
    public void testAllPhoneNumbersByCustomerEmptiness() {
        List<PhoneNumberSimpleView> actual = phoneControllerFail.getPhoneNumberByCustomer(1);
        assertNull(actual);
    }

    @Test
    public void testActiveNumberWithSuccess() {
        boolean actual = phoneControllerSuccess.phoneActivate("");
        assertTrue(actual);
    }

    @Test
    public void testActiveNumberUnsuccessfully() throws Exception {
        boolean actual = phoneControllerFail.phoneActivate("");
        assertFalse(actual);
    }
}
package app;

import com.google.gson.JsonSyntaxException;
import controllers.PhoneController;
import views.MessageView;
import views.PhoneNumberSimpleView;

import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by diogo on 25/05/2018.
 */
public class PhoneRestApi {

    private PhoneController phoneController;

    public PhoneRestApi(PhoneController phoneController) {
        this.phoneController = phoneController;
    }

    public void processApi() {

        get("/phone/number", (req, res) -> phoneController.getAllPhoneNumbers(), new GsonTransformer());

        get("/phone/number/:customerId", (req, res) -> {

            String customerIdStr = req.params(":customerId");
            if( !Utils.isInteger(customerIdStr,10) ) {
                res.status(404);
                return new MessageView("Customer not found!");
            }

            int customerId = Integer.parseInt(customerIdStr);
            List<PhoneNumberSimpleView> view = phoneController.getPhoneNumberByCustomer(customerId);
            if( view == null ) {
                res.status(404);
                return new MessageView("Customer not found!");
            }
            return view;
        }, new GsonTransformer());

        put("/phone/number/activate", (req, res) -> {
            Map<String, String> body;
            try {
                body = GsonParser.parseBody(req);
            } catch(JsonSyntaxException e) {
                return "Input JSON is invalid. Request body must be valid JSON!";
            }

            String number = body.get("number");
            if( number == null ) {
                res.status(400);
                return new MessageView("Phone number not found!");
            }

            boolean result = phoneController.phoneActivate(number);
            if( !result ) {
                res.status(404);
                return new MessageView("Phone number not found!");
            }

            return new MessageView("Phone number activated successfully!");
        }, new GsonTransformer());
    }
}

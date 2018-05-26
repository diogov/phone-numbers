package app;

import spark.ResponseTransformer;
import com.google.gson.Gson;


/**
 * Created by diogo on 25/05/2018.
 */

public class GsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
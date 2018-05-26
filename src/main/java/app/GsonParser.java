package app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spark.Request;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by diogo on 26/05/2018.
 */
public class GsonParser {

    public static Map<String, String> parseBody(Request request) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();

        return gson.fromJson(request.body(), type);
    }
}

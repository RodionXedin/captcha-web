package com.firefly.captcha.utils;

import com.firefly.captcha.model.entity.User;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

/**
 * Created by rodio on 09.12.2015.
 */
public class JsonUtils {


    private static final String RESULT = "result";
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String USER_NAME_JSON_ATTRIBUTE = "userName";
    private static final String NEW_USER_JSON_ATTRIBUTE = "newUser";
    public static final String ERROR_JSON_ATTRIBUTE = "error";


    public static JSONObject success() {
        return new JSONObject().put(RESULT, SUCCESS);
    }

    public static JSONObject failure() {
        return new JSONObject().put(RESULT, FAILURE);
    }

    public static JSONObject addBasicUserInfo(JSONObject jsonObject, User user) {

        return jsonObject.put(USER_NAME_JSON_ATTRIBUTE, user.getFirstName())
                .put(NEW_USER_JSON_ATTRIBUTE, false);
    }

    public static JSONObject addBasicUserInfo(JSONObject jsonObject, User user, boolean newUser) {
        return jsonObject.put(USER_NAME_JSON_ATTRIBUTE, user.getFirstName())
                .put(NEW_USER_JSON_ATTRIBUTE, newUser);
    }

    public static JSONObject addError(JSONObject jsonObject, String text) {
        return jsonObject.put(ERROR_JSON_ATTRIBUTE, text);
    }
}

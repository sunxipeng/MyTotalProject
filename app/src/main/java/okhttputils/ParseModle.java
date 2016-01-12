package okhttputils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/12.
 */
public class ParseModle {

    private ParseModle() {};

    private static ParseModle parseModle;

    public static ParseModle getInstatceParceModle() {

        if (parseModle == null) {

            parseModle = new ParseModle();

            return parseModle;
        }
        return parseModle;
    }


    public static <T extends Serializable> T parseResult(String response,Class<T> T){

        try {
            JSONObject jsonObject = new JSONObject(response);

            String result = jsonObject.optString("result");

            Gson gson = new Gson();

            T tClass = (T) gson.fromJson(result, T);

            return tClass;

        } catch (JSONException e) {

            e.printStackTrace();

            return null;
        }

    }
}

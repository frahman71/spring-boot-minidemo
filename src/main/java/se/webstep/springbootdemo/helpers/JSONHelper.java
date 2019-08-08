package se.webstep.springbootdemo.helpers;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHelper {

    public static String getJSONVariantOfObjectResponse(String responseName, Object responseObject){

        JSONObject jsonObject=new JSONObject();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String jsonString=objectMapper.writeValueAsString(responseObject);

            jsonObject.put(responseName,jsonString);
        } catch (JsonProcessingException | JSONException e) {
            e.printStackTrace();
        }
        return StringEscapeUtils.unescapeJava(jsonObject.toString());
    }


    public static String getJSONStringBasedOnInputString(String label, String inputString){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put(label, inputString);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getJSONStringBasedOnObjectArrayAndStatus(String label, Object inputObjects[], String statusLabel, String status){

        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        ObjectMapper objectMapper=new ObjectMapper();

        try{
            for(Object inputObject:inputObjects){
                String inputObjectAsJSON=objectMapper.writeValueAsString(inputObject);
                jsonArray.put(inputObjectAsJSON);
            }
            jsonObject.put(label,jsonArray);
            jsonObject.put(statusLabel,status);

            return StringEscapeUtils.unescapeJava(jsonObject.toString());
        } catch (JsonProcessingException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}

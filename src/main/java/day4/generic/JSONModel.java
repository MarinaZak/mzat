package day4.generic;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import  org.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;

public abstract class JSONModel<T> {
    static ObjectMapper mapper;
    ObjectMapper getObjectMapper(){
        if(mapper==null){
            mapper=initMapper();
        }
        return mapper;
    }

    private ObjectMapper initMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //custom param
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        return mapper;
    }

    public JSONObject asJson() {
        try {
            return new JSONObject(getObjectMapper().writeValueAsString(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public  <T> T makeMyFromJsonString(Class<T> currentClass, String jsonObjectString) {
        try {
            return getObjectMapper().readValue(jsonObjectString, currentClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
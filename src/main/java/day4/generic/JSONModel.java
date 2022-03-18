package day4.generic;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import  org.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class JSONModel<T> {
    static ObjectMapper mapper;
    ObjectMapper getObjectMapper(){
        if(mapper==null){
            mapper=intitMapper();
        }
        return mapper;
    }

    private ObjectMapper intitMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        return  mapper;
    }

    public JSONObject asJson(){
        try {
            return new JSONObject(getObjectMapper().getObjectMapper().writeValueAsString(this));
        } catch (i0Exception e){
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static <T> makeMyFromJsonString(Class<T> currenyClass, String jsonObjectString){
        return getObjectMapper().readValue(jsonObjectString, currenyClass);
    }
}

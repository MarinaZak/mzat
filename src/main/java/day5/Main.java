package day5;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input.json");
        String inputString = null;
        try {
            inputString = Files.readString(inputFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(inputString);

        JSONObject json = new JSONObject(inputString);

        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        try {
            user = mapper.readValue(inputString, User.class);
            System.out.println(user);
        } catch (IOException e){
            e.printStackTrace();
        }

        user.setPhoneList(new ArrayList<>());
        user.getPhoneList().add("+380666666");
        user.getPhoneList().add("+380999999");

        System.out.println(user);

        JSONObject outputJson = new JSONObject(user);

        System.out.println(outputJson);

        File outputFile = new File("output.json");

        PrintWriter out = null;

        try {
            out = new PrintWriter(outputFile);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        out.println(outputJson);
        out.close();

//        Files.write(outputFile.outputJson.toString());

    }
}

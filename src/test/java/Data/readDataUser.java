package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class readDataUser {
    String successfulRegister = "successfulRegister";

    private String[] readJson(String testStatus) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("./src\\test\\resources\\userData.json");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
            String firstName = (String) users.get("firstName");
            String lastName = (String) users.get("lastName");
            String address = (String) users.get("address");
            String city = (String) users.get("city");
            String state = (String) users.get("state");
            String zipcode = (String) users.get("zipcode");
            String phone = (String) users.get("phone");
            String ssn = (String) users.get("ssn");
            String userName = (String) users.get("userName");
            String password = (String) users.get("password");


            arr[i] = firstName + "," + lastName + ","+address + "," +city + state +","+ zipcode+ ","+ phone + "," +ssn+ ","+ userName + "," +password  ;
        }
        return arr;
    }


    public String[] testDataForSuccessfulRegister() throws IOException, ParseException {
        return readJson(successfulRegister);
    }



}

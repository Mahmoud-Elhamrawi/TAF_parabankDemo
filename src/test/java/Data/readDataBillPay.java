package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class readDataBillPay {
    String successfulBillPay = "successfulBillPay";

    private String[] readDataBill(String testStatus) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("./src\\test\\resources\\billpay.json");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);

            String payeeName = (String) users.get("payeeName");
            String address = (String) users.get("address");
            String city = (String) users.get("city");
            String state = (String) users.get("state");
            String zipcode = (String) users.get("zipcode");
            String phone = (String) users.get("phone");
            String Account = (String) users.get("Account");
            String Amount = (String) users.get("Amount");



            arr[i] = payeeName + ","+address + "," +city+","+ state +","+ zipcode+ ","+ phone + "," +Account+ ","+ Amount   ;
        }
        return arr;
    }


    public String[] testDataForSuccessfulPayBill() throws IOException, ParseException {
        return readDataBill(successfulBillPay);
    }



}

package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class readAccountNums {
   public String checkingNum ;
    public void readJsonNum() throws IOException, ParseException {





        String filePath  = "./src\\test\\resources\\accountNumber.json" ;
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray) {
            JSONObject jsonObject = (JSONObject) jsonObj;
            checkingNum = (String) jsonObject.get("checkNum");
        }

    }

}

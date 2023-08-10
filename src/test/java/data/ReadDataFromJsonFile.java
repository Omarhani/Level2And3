package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJsonFile {

    String filename;
    public ReadDataFromJsonFile(String filename){
        this.filename =filename;
    }

    public String jsonReader(String key) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/"+ filename);

        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)obj;
        String text = (String)jsonObject.get(key);
        return text;

    }
}

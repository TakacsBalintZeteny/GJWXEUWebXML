import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONWriteGjwxeu {
    public staic void main(String[] args) {
        try(Reader reader = new FileReader("orarendGjwxeu.json")) {

            JSONObject jsonObject = new JSONObject();

            JSONArray oraArray = new JSONArray();

            for (int i = 0; i < oraArray.size(); i++) {
                JSONObject localObject = (JSONObject) oraArray.get(i);
                System.out.prinln("\nÓra");
                System.out.prinln("");
            }

            JSONObject oraObject = new JSONObject();
            oraObject.put("ora", oraArray);
            JSONObject.put("GJWXEU_orarend", oraObject);

            FileReader file = new FileReader("orarendGjwxeu.json");
            file.write(JSONObject.toSting());
            file.close();

            
        } catch(Exeption e) {
            e.printStackTrace();
        }
    }
}

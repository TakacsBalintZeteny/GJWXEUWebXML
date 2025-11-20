package hu.gjwxeu;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class App {

    public static void main(String[] args) {

        try {
            // JSON beolvasása
            JSONObject json = new JSONObject(
                    new JSONTokener(App.class.getResourceAsStream("/orarendGjwxeu.json")));

            // Schema beolvasása
            JSONObject schemaJson = new JSONObject(
                    new JSONTokener(App.class.getResourceAsStream("/orarendGjwxeuSchema.json")));

            // Schema betöltése
            Schema schema = SchemaLoader.load(schemaJson);

            // Validáció
            schema.validate(json);

            System.out.println("A JSON érvényes a sémára!");

        } catch (Exception e) {
            System.out.println("Hiba a validáció során:");
            System.out.println(e.getMessage());
        }
    }
}

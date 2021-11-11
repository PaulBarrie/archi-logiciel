package esgi.barrie.cc1.infrastructure.db;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFsDB implements DB {
    private final String fileLocation;
    private final JsonObject jsonDB;
    
    public JsonFsDB(String fileLocation) {
        this.fileLocation = fileLocation;
        this.init();
        this.jsonDB = this.getAll();
    }

    public static JsonFsDB of(String fileLocation) {
        return new JsonFsDB(fileLocation);
    }

    @Override
    public void init()  {
        try {
            File json = new File(this.fileLocation);
            if (json.createNewFile()) {
                System.out.println("File created: " + json.getName());
            } else {
                System.out.println("DB already exists. Nothing to do.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void createTable(String table) throws Exception {
        JsonObject jsonObject = this.getAll();
        JsonArray tableArray = new JsonArray();
        jsonObject.add(table, tableArray);
        this.persist();
    }

    @Override
    public JsonObject getAll() {
        try {
            FileReader reader = new FileReader(this.fileLocation);
            return  JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            System.out.println("DB has not been initialized. Creating it.");
        }
        return null;
    }

    @Override
    public JsonArray getTable(String table) {
        return this.jsonDB.getAsJsonArray(table);
    }

    @Override
    public void persist() throws IOException {
        try {
            Files.write(Paths.get(this.fileLocation), this.jsonDB.getAsString().getBytes());
        } catch (IOException e) {
            System.out.println("An error occured while persisting data.");
        }

    }

    public JsonObject insertIntoTable(String table, JsonElement jsonElement) {
        JsonArray arrayTable=  this.getTable(table);
        this.jsonDB.add(table, arrayTable);
        return this.jsonDB;
    }


}

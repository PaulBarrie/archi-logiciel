package esgi.barrie.cc1.infrastructure.db;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;

public interface DB {
    void init();
    void createTable(String table) throws Exception;
    JsonObject getAll();
    JsonElement getTable(String table);
    void persist() throws IOException;
}

package esgi.barrie.al.service.db;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import esgi.barrie.al.infrastructure.db.JsonFsDB;
import esgi.barrie.al.model.serialization.UserTypeAdapter;
import esgi.barrie.al.model.user.User;
import esgi.barrie.al.service.serialization.AdapterEngineFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUserDatabaseService extends JsonDatabaseService<User> {
    private final Gson adapter = AdapterEngineFactory.withJsonAdapter(User.class, new UserTypeAdapter());

    private JsonUserDatabaseService(JsonFsDB db)  {
        super(db, User.class);
    }


    public static DatabaseService<JsonObject, User> of(JsonFsDB db) {
        return new JsonUserDatabaseService(db);
    }

    @Override
    public ArrayList<User> get() throws IOException {
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        JsonArray tableJson = super.getTable();
        if (tableJson == null) {
            throw new IOException("Error while getting table " + User.class.getSimpleName());
        }
        return this.adapter.fromJson(tableJson, listType);
    }
    @Override
    public User getItem(Map<String, String> filter) throws IOException {
        User user = this.adapter.fromJson(super.get(filter), User.class);
        return user;
    }

    @Override
    public void insert(User toInsert) throws IOException {
        JsonObject userObj = (JsonObject) this.adapter.toJsonTree(toInsert, User.class);
        super.insert(userObj);
    }
    @Override
    public void deleteItem(Map<String, String> filter) throws IOException {
        super.delete(filter);
    }

}

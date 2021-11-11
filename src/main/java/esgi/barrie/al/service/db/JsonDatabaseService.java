package esgi.barrie.al.service.db;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import esgi.barrie.al.infrastructure.db.JsonFsDB;
import esgi.barrie.al.model.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public abstract class JsonDatabaseService<T> extends DatabaseService<JsonObject, T>{
    protected Class<T> class_;
    protected JsonObject db;


    public abstract void insert(User toInsert) throws IOException;
    public abstract ArrayList<T> get() throws IOException;
    public abstract T getItem(Map<String,String> filter) throws IOException;
    public abstract void deleteItem(Map<String, String> filter) throws IOException;

    public JsonDatabaseService(JsonFsDB db, Class<T> class_) {
        super(db);
        this.db = (JsonObject) super.getDb().getInstance();
        this.class_ = class_;
    }


    @Override
    public JsonArray getTable() throws IOException {
        JsonArray table =this.db.getAsJsonArray(this.getClass_().getSimpleName());
        if(Objects.isNull(table)) {
            System.out.println("Table not init yet...");
            ((JsonFsDB) super.db).createTable(this.getClass_().getSimpleName());
            return new JsonArray();
        }
        return table;
    }

    @Override
    public JsonObject get(Map<String, String> filter) throws IOException {
        Map.Entry<String,String> filterVal = filter.entrySet().iterator().next();
        for(JsonElement item: this.getTable()) {
            if (item.getAsJsonObject().get(filterVal.getKey()).getAsString() == filterVal.getValue()) {
                return (JsonObject) item;
            }
        }
        return null;
    }

    @Override
    public JsonObject insert(JsonObject toInsert) throws IOException {
        JsonArray newTable = this.db.getAsJsonArray(this.class_.getSimpleName());
        if(Objects.isNull(newTable)) {
            newTable =  new JsonArray();
        }
        newTable.add(toInsert);
        this.db.add(this.class_.getSimpleName(), newTable);
        this.getDb().persist();
        return this.db;
    }

    @Override
    public JsonObject update(Map<String, String> filter, JsonObject newItem) throws IOException {
        JsonObject toDelete = this.get(filter);
        this.getTable().remove(toDelete);
        this.getTable().add(newItem);
        this.getDb().persist();
        return (JsonObject) super.getDb().getInstance();
    }

    @Override
    public JsonObject delete(Map<String, String> filter) throws IOException {
        JsonObject toDelete = this.get(filter);
        this.getTable().remove(toDelete);
        this.getDb().persist();
        return this.db;
    }
    public Class<T> getClass_() {
        return this.class_;
    }
}

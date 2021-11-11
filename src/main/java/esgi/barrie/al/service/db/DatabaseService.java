package esgi.barrie.al.service.db;

import esgi.barrie.al.infrastructure.db.DB;

import java.io.IOException;
import java.util.Map;

public abstract class DatabaseService<T, K> {
    protected DB db;
    //private Object DatabaseService;
    //protected final User user;
    //protected ArrayList<T> table;

    public DatabaseService(DB db) {
        this.db = db;

        //this.table = table;
        //this.user = user;
        //this.table = db.get(TABLE_NAME);
    }


    public abstract Object getTable() throws IOException;
    public abstract T get(Map<String, String> filter) throws IOException;
    public abstract T insert(T toInsert) throws IOException;
    public abstract T update(Map<String, String> filter, T newItem) throws IOException;
    public abstract T delete(Map<String, String> filter) throws IOException;
    public DB getDb() {
        return db;
    }
    public void setDb(DB db) {
        this.db = db;
    }
}

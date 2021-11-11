package esgi.barrie.al.service.serialization;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;


public final class AdapterEngineFactory {
    private AdapterEngineFactory() {
        throw new AssertionError();
    }

    public static <T> Gson withJsonAdapter(Class<T> classz, TypeAdapter<T> typeAdapter) {
        return new GsonBuilder()
                .registerTypeHierarchyAdapter(classz, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
    }
}

package esgi.barrie.al.model.serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Credentials extends TypeAdapter<Credentials> {
    @Override
    public void write(JsonWriter jsonWriter, Credentials credentials) throws IOException {

    }

    @Override
    public Credentials read(JsonReader jsonReader) throws IOException {
        return null;
    }
}

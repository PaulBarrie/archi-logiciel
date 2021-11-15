package esgi.barrie.al.common.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import esgi.barrie.al.common.user.Credentials;

import java.io.IOException;

public class CredentialsAdapter extends TypeAdapter<Credentials> {
    private final Gson gson = new Gson();
    @Override
    public void write(JsonWriter jsonWriter, Credentials credentials) throws IOException {
        jsonWriter.beginObject().
                name("Username").value(credentials.getUsername())
                .name("Password").value(credentials.getPassword());
        jsonWriter.endObject();
    }

    @Override
    public Credentials read(JsonReader jsonReader) throws IOException {
        String fieldName;
        Credentials credentials = Credentials.nullCredentials();
        jsonReader.beginObject();

        while(jsonReader.hasNext()) {
            fieldName = jsonReader.nextName();

            switch (fieldName) {
                case "Username":
                    credentials.setUsername(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Password":
                    credentials.setPassword(gson.getAdapter(String.class).read(jsonReader));
                    break;
            }
        }
        jsonReader.endObject();
        return credentials;
    }
}

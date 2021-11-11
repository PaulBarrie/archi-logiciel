package esgi.barrie.cc1.model.serialization;

import esgi.barrie.cc1.model.user.Address;
import esgi.barrie.cc1.model.user.Credentials;
import esgi.barrie.cc1.model.user.Phone;
import esgi.barrie.cc1.model.user.User;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class UserTypeAdapter extends TypeAdapter<User> {
    private final Gson gson = new Gson();
    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("ID").value(user.getId());
        jsonWriter.name("Firstname").value(user.getFirstName());
        jsonWriter.name("Lastname").value(user.getLastName());
        jsonWriter.name("Birth").value(user.getBirth());
        jsonWriter.name("Email").value(user.getEmail());

        gson.getAdapter(Phone.class).write(jsonWriter, user.getPhone());
        gson.getAdapter(Credentials.class).write(jsonWriter, user.getCredentials());
        if(user.getAddress().isPresent()) {
            gson.getAdapter(Address.class).write(jsonWriter, user.getAddress().get());
        }

    }

    @Override
    public User read(JsonReader jsonReader) throws IOException {
        String fieldName;
        User user = User.nullUser();
        jsonReader.beginObject();

        while(jsonReader.hasNext()) {
            fieldName = jsonReader.nextName();

            switch (fieldName) {
                case "Firstname":
                    user.setFirstName(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Lastname":
                    user.setLastName(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Birth":
                    user.setBirth(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Email":
                    user.setEmail(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Credentials":
                    user.setCredentials(gson.fromJson(fieldName, Credentials.class));
                    break;
                case "Phone":
                    user.setPhone(gson.fromJson(fieldName, Phone.class));
                    break;
                case "Address":
                    user.setAddress(gson.fromJson(fieldName, Address.class));
                    break;
            }
        }
        return null;
    }
}

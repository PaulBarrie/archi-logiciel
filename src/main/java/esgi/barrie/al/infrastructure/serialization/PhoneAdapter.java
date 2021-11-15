package esgi.barrie.al.common.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import esgi.barrie.al.common.user.Phone;

import java.io.IOException;

public class PhoneAdapter extends TypeAdapter<Phone> {
    private final Gson gson = new Gson();
    @Override
    public void write(JsonWriter jsonWriter, Phone phone) throws IOException {
        jsonWriter.beginObject().
                name("Code").value(phone.getCountryCode())
                .name("Number").value(phone.getNumber());
        jsonWriter.endObject();
    }

    @Override
    public Phone read(JsonReader jsonReader) throws IOException {
        String fieldName;
        Phone phone = Phone.nullPhone();
        jsonReader.beginObject();

        while(jsonReader.hasNext()) {
            fieldName = jsonReader.nextName();

            switch (fieldName) {
                case "Code":
                    phone.setCountryCode(gson.getAdapter(Integer.class).read(jsonReader));
                    break;
                case "Number":
                    phone.setNumber(gson.getAdapter(String.class).read(jsonReader));
                    break;
            }
        }
        jsonReader.endObject();
        return phone;
    }
}

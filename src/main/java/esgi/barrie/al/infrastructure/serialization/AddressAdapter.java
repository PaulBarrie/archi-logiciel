package esgi.barrie.al.common.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import esgi.barrie.al.common.user.Address;

import java.io.IOException;

public class AddressAdapter extends TypeAdapter<Address> {
    private final Gson gson = new Gson();
    @Override
    public void write(JsonWriter jsonWriter, Address address) throws IOException {
        jsonWriter.beginObject().
                name("StreetNumber").value(address.getStreetNumber())
                .name("StreetName").value(address.getStreetName())
                .name("ZipCode").value(address.getZipCode())
                .name("City").value(address.getCity())
                .name("Country").value(address.getCountry());
        jsonWriter.endObject();
    }

    @Override
    public Address read(JsonReader jsonReader) throws IOException {
        String fieldName;
        Address address = Address.nullAddress();
        jsonReader.beginObject();

        while(jsonReader.hasNext()) {
            fieldName = jsonReader.nextName();

            switch (fieldName) {
                case "StreetNumber":
                    address.setStreetNumber(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "StreetName":
                    address.setStreetName(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "ZipCode":
                    address.setZipCode(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "City":
                    address.setCity(gson.getAdapter(String.class).read(jsonReader));
                    break;
                case "Country":
                    address.setCountry(gson.getAdapter(String.class).read(jsonReader));
                    break;
            }
        }
        jsonReader.endObject();
        return address;
    }
}

package esgi.barrie.al.service.serialization;

import com.google.gson.*;
import esgi.barrie.al.service.serialization.SerializationEngine;

import java.lang.reflect.Type;
import java.util.Objects;

public final class JsonAdapter<T> implements JsonSerializer, JsonDeserializer {

    private final Gson gson;

    public JsonAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive primitive = (JsonPrimitive) jsonObject.get(Type.class.getSimpleName());
        Class class_ = getObjectClass(primitive.getAsString());
            return jsonDeserializationContext.deserialize(jsonObject.get(Type.class.getSimpleName()), class_);
    }

    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(o.getClass().getSimpleName(), jsonSerializationContext.serialize(o));
        return jsonObject;
    }

    private Class getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
    }
}

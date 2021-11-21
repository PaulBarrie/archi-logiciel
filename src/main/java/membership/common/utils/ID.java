package membership.common.utils;

import java.util.UUID;

public class ID {
    private final String value;
    private ID(String value) {
        this.value = value;
    }
    public static ID create() {
        return new ID(UUID.randomUUID().toString());
    }
    public String getValue() {
        return value;
    }
}

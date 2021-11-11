package esgi.barrie.al.service.serialization;

import java.util.function.Function;

public interface SerializationEngine<T> extends Function<T, String> {
}

package membership.handler;

public interface Handler<T> {
    Handler<T> setNext(Handler<T> next);
    String check(T request);
    String checkNext(T request);
}

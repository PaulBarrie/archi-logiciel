package org.esgi.trademe.kernel.event;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}

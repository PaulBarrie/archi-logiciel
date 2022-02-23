package org.esgi.trademe.kernel.event;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}

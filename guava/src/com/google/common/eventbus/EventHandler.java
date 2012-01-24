package com.google.common.eventbus;

/**
 * EventHandler interface.  Pulled out into an interface to allow more flexible
 * HandlerFinderStrategy implementations.
 *
 * @author Kris J. Pruden
 */
public interface EventHandler {
    /**
     * Handle an event (typically by forwarding it to a wrapped listener).
     *
     * @param event the event to handle
     * @throws Exception if an exception occurs during event handling
     */
    public void handleEvent(Object event) throws Exception;
}

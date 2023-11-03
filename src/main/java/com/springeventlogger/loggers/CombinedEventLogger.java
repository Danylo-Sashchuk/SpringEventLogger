package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;

import java.util.Collection;

/**
 * Danylo Sashchuk <p>
 * 11/3/23
 */

public class CombinedEventLogger implements EventLogger {
    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}

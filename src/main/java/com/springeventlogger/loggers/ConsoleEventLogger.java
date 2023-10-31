package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}

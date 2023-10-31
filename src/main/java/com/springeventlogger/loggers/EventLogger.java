package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}

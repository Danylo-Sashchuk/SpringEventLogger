package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            super.logEvent(event);
            cache.clear();
        }
    }

    private void destroy() {
        if(!cache.isEmpty()) {
            cache.forEach(super::logEvent);
        }
    }
}

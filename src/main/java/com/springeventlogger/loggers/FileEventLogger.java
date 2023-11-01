package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class FileEventLogger implements EventLogger {
    private File file;
    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        this.file = new File(fileName);
    }
}

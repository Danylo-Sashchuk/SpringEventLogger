package com.springeventlogger.loggers;

import com.springeventlogger.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class FileEventLogger implements EventLogger {
    private String fileName;

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

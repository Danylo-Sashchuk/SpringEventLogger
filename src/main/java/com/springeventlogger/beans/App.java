package com.springeventlogger.beans;

import com.springeventlogger.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class App {
    private final EventLogger defaultLogger;
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1", EventType.INFO);
        event = (Event) ctx.getBean("event");
        app.logEvent(event, "Some event for 2", EventType.ERROR);
        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 3", null);

        ctx.close();
    }

    public void logEvent(Event event, String msg, EventType type) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }
}

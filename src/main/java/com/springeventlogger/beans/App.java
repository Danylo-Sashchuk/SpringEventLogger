package com.springeventlogger.beans;

import com.springeventlogger.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1");
        event = (Event) ctx.getBean("event");
        app.logEvent(event, "Some event for 2");
    }

    public void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}

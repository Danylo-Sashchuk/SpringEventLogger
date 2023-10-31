package com.springeventlogger;

/**
 * Danylo Sashchuk <p>
 * 10/31/23
 */

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App() {
//        this.client = new Client("1", "John Smith");
//        this.eventLogger = new ConsoleEventLogger();
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1");
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
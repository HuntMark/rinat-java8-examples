package com.example.stepik_java.logging;

import java.util.logging.*;

public class ConfigureLogging {
    public static void main(String[] args) {
    }

    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger loggerParent = Logger.getLogger("org.stepic.java");
        loggerParent.setUseParentHandlers(false);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        loggerParent.addHandler(handler);
    }
}

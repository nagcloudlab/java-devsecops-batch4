package com.npci;


// to write concise code
// to avoid boilerplate code

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class Why_We_Need_Functional_Code {

    public static void main(String[] args) throws Exception {

        String logMessage = "server started at 10:00 AM";

        FileWriter fileWriter = new FileWriter("log.txt", true);

        Consumer<String> consoleLogger = (message) -> {
            System.out.println("Log: " + message);
        };
        Consumer<String> fileLogger = (message) -> {
            // Simulate writing to a file
            try {
                fileWriter.write(message);
                fileWriter.write("\n");
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

//        consoleLogger.accept(logMessage);
//        fileLogger.accept(logMessage);

        Consumer<String> consoleAndFileLogger = consoleLogger.andThen(fileLogger);

        consoleAndFileLogger.accept(logMessage);

    }

}

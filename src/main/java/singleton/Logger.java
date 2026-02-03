package singleton;
//Goal:
//
//Your goal is to design and implement a Logger system in Java using the Singleton design pattern. The Logger system should allow writing log messages to a file.
//
//Guidelines:
//
//Implement the Logger class as a Singleton.
//The Logger class should provide methods for writing log messages to a file. Each log message should be written on a new line in the file.
//The constructor of the Logger class should initialize the logger with a default file name.
//Provide a method in the Logger class to set the file name dynamically. This method should close the current file and open a new file with the specified name.
//Ensure that the Logger class handles file I/O operations safely and gracefully. Thus, add the necessary try-catch blocks to handle exceptions.

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter writer;
    private String fileName = "some_log.txt";

    private Logger() {
        try {
            writer = new FileWriter(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String newFileName) {
        try {
            if (writer != null) {
                writer.close();
            }
            fileName = newFileName;
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("Error switching log file: " + e.getMessage());
        }
    }

    public synchronized void write(String message) {
        try {
            writer.write(message + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing log message: " + e.getMessage());
        }
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
        }
    }
}

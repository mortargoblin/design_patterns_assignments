import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final String DEFAULT_FILE_NAME = "log.txt";

    private static Logger instance;

    private String fileName;
    private BufferedWriter writer;

    private Logger() {
        openFile(DEFAULT_FILE_NAME);
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        closeFile();
        openFile(fileName);
    }

    public synchronized void write(String message) {
        if (writer == null) {
            System.err.println("Logger: no file open, message dropped: " + message);
            return;
        }
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Logger: failed to write message: " + e.getMessage());
        }
    }

    public synchronized void close() {
        closeFile();
    }

    private void openFile(String fileName) {
        try {
            this.writer = new BufferedWriter(new FileWriter(fileName));
            this.fileName = fileName;
        } catch (IOException e) {
            System.err.println("Logger: failed to open file " + fileName + ": " + e.getMessage());
            this.writer = null;
        }
    }

    private void closeFile() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Logger: failed to close file " + fileName + ": " + e.getMessage());
            }
            writer = null;
        }
    }
}

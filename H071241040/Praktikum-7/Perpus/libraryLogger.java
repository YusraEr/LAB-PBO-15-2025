package Perpus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class libraryLogger {
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String log = LocalDateTime.now().format(formatter) + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}

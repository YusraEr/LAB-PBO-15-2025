import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public void logActivity(String activity) {
        String log = String.format("[%s] %s", java.time.LocalDateTime.now(), activity);
        logs.add(log);
    }

    public String getAllLogs() {
        if (logs.isEmpty()) return "Belum ada aktivitas.";
        StringBuilder sb = new StringBuilder("Log Aktivitas:\n");
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
}

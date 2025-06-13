import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;
    private DateTimeFormatter formatter;
    
    public LibraryLogger() {
        this.logs = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
    
    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " - " + activity;
        logs.add(logEntry);
        return logEntry;
    }
    
    public String getLogs() {
        if (logs.isEmpty()) {
            return "Tidak ada log aktivitas";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("┌─────────────────────────────────────────────────────────────────────────────┐\n");
        sb.append("│                              LOG AKTIVITAS                                  │\n");
        sb.append("├─────────────────────────────────────────────────────────────────────────────┤\n");
        
        for (String log : logs) {
            String paddedLog = String.format("│ %-75s │", log);
            sb.append(paddedLog).append("\n");
        }
        
        sb.append("└─────────────────────────────────────────────────────────────────────────────┘");
        return sb.toString();
    }
    
    public void clearLogs() {
        logs.clear();
    }
    
    public int getLogCount() {
        return logs.size();
    }
}
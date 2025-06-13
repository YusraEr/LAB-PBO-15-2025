package TP7.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger(){
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public String getLogs(){
        if (logs.isEmpty()){
            return "Belum ada aktifitas";
        }

        StringBuilder sb = new StringBuilder();
        for (String log : logs){
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs(){
        logs.clear();
    }
}

package TP8.DownloadFile;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        completedDownloads++;
        String status = duration <= 2 ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        results.add(new Result(fileId, threadName, duration, status));
        
        // Check if all downloads are completed
        if (completedDownloads == totalFiles) {
            allDone = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of files to download: ");
        totalFiles = scanner.nextInt();

        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();

        Runnable progressTask = () -> {
            int elapsed = 0;
            try {
                while (!allDone) {
                    System.out.println("Downloading files... (" + elapsed + "s)");
                    Thread.sleep(1000);
                    elapsed++;
                }
                System.out.println("Downloading completed!\n");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        uiExecutor.submit(progressTask);

        Random rand = new Random();
        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.submit(() -> {
                try {
                    int duration = rand.nextInt(3) + 1;
                    Thread.sleep(duration * 1000L);
                    recordResult(fileId, duration, Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        downloadExecutor.shutdown();

        try {
            downloadExecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        uiExecutor.shutdownNow();
        try {
            uiExecutor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        // Print report
        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        results.sort(Comparator.comparingInt(r -> r.fileId));
        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8ds | %-8s%n",
                    r.fileId, r.threadName, r.duration, r.status);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);

        scanner.close();
    }
}
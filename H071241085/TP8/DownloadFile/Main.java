package DownloadFile;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    // TODO (1)
    // Lengkapi method untuk merekam hasil download file sesuai dengan poin-poin berikut:
    // - Setiap kali method dipanggil, total file yang selesai didownload akan bertambah
    // - Tentukan status download berdasarkan durasi proses download
    // (durasi ≤ 2 detik maka "Success", selain itu "Timeout")
    // - Jika status "Success", file yang berhasil didownload akan bertambah
    // - Buat objek Result dan tambahkan ke list results untuk menyimpan hasil setiap proses
    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        completedDownloads++;
        String status = (duration <= 2) ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        results.add(new Result(fileId, threadName, duration, status));
    }

    public static void main(String[] args) {

        // TODO (2)
        // Gunakan Scanner untuk meminta input jumlah file yang akan diunduh dari pengguna
        System.out.print("Enter the number of files to download: ");
        Scanner sc = new Scanner(System.in);
        totalFiles = sc.nextInt();

        // TODO (3)
        // Siapkan dua executor service dengan fungsi sebagai berikut:
        // - Satu dengan 3 thread untuk menangani proses download secara paralel (downloadExecutor)
        // - Satu lagi dengan 1 thread untuk menampilkan proses download ke terminal (uiExecutor)
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        // Mencatat waktu mulai
        long startTime = System.currentTimeMillis();

        // TODO (4)
        // Buat tugas yang dijalankan oleh uiExecutor untuk menampilkan proses download:
        // - Tampilkan pesan ke terminal setiap detik sebagai indikator progres,
        // dengan format -> Downloading files... ({time}s)
        // - Hentikan ketika semua file selesai diunduh
        uiExecutor.submit(() -> {
            long currentTime = 1;
            while (!allDone) {
                // long currentTime = (System.currentTimeMillis() - startTime) / 1000;
        
                System.out.println("Downloading files... (" + currentTime + "s)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                currentTime++;
            }
        }); 
     
        // TODO (5)
        // Buat dan jalankan tugas download untuk setiap file menggunakan downloadExecutor:
        // - Simulasikan proses download dengan jeda waktu acak (random 1-3 detik)
        // - Setelah selesai, catat hasilnya dengan menyimpan fileId, duration, dan threadname
        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.submit(() -> {
                int duration = ThreadLocalRandom.current().nextInt(1, 4);
                try {
                    Thread.sleep(duration * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                recordResult(fileId, duration, Thread.currentThread().getName());
            });
        }

        // TODO (6)
        // Tutup downloadExecutor agar tidak menerima tugas baru
        downloadExecutor.shutdown();
        
        // TODO (7)
        // Tunggu semua tugas download selesai sebelum lanjut ke proses berikutnya   
        try {
            downloadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
        
        // TODO (8)
        // Ketika semua proses download sudah selesai:
        // - Tandai bahwa semua download sudah selesai dengan mengubah nilai allDone
        // - Hentikan proses uiExecutor dan tunggu hingga semua tugas selesai,
        // seperti pada downloadExecutor
        allDone = true;
        uiExecutor.shutdown();
        try {
            uiExecutor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mencatat total waktu proses secara keseluruhan
        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        // Header tabel
        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        // Urutkan hasil berdasarkan fileId
        results.sort(Comparator.comparingInt(r -> r.fileId));

        // Tampilan hasil setiap proses download dalam bentuk table
        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        // Ringkasan Proses
        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);

        sc.close();
    }
}

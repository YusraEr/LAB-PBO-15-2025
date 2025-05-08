package kendaraan;
import java.util.Date;

public interface IServiceable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getTanggalServisTerakhir();
    double hitungBiayaServis();
}

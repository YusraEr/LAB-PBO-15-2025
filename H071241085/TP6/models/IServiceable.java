package tuprak_6.models;

import java.util.Date;

public interface IServiceable {
    public boolean periksaKondisi();

    public void lakukanServis();

    public Date getWaktuServisBerikutnya();

    public double hitungBiayaServis();
}

package id.ac.budiluhur.absensi.dao;

import java.time.LocalDateTime;

public class AbsensiDAO {
    private String nip;
    private String checktime;
    private String signature;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "AbsensiDAO{" +
                "nip='" + nip + '\'' +
                ", checktime='" + checktime + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}

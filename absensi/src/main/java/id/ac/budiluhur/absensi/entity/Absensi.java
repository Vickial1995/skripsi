package id.ac.budiluhur.absensi.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "absensi")
public class Absensi {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nip;
    @Column
    private LocalDateTime checktime;

    public Absensi() {
    }

    public Absensi(String nip, LocalDateTime checktime) {
        this.nip = nip;
        this.checktime = checktime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public LocalDateTime getChecktime() {
        return checktime;
    }

    public void setChecktime(LocalDateTime checktime) {
        this.checktime = checktime;
    }

    @Override
    public String toString() {
        return "Absensi{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", checktime=" + checktime +
                '}';
    }
}

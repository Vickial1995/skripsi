package id.ac.budiluhur.absensi.repository;

import id.ac.budiluhur.absensi.entity.Absensi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAbsensi extends JpaRepository<Absensi,Integer> {
}

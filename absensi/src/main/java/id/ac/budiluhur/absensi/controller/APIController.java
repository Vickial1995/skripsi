package id.ac.budiluhur.absensi.controller;

import id.ac.budiluhur.absensi.ArgonHashing;
import id.ac.budiluhur.absensi.dao.AbsensiDAO;
import id.ac.budiluhur.absensi.entity.Absensi;
import id.ac.budiluhur.absensi.repository.RepositoryAbsensi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private RepositoryAbsensi repositoryAbsensi;

    @PostMapping("/add_absensi")
    public Map<String,Object> addAbsensi(@RequestBody AbsensiDAO absensiDAO){
        HashMap<String,Object> mapReturn = new HashMap<>();
        System.out.println(absensiDAO);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime checkTime = LocalDateTime.parse(absensiDAO.getChecktime(),formatter);
        Absensi absensi = new Absensi(absensiDAO.getNip(),checkTime);
        System.out.println(absensi);

        if(ArgonHashing.verify(absensiDAO.getNip()+absensiDAO.getChecktime(),absensiDAO.getSignature())){
            mapReturn.put("status", "success");
            repositoryAbsensi.save(absensi);
        }else{
            mapReturn.put("status", "failed");
            mapReturn.put("info", "verification failed");
        }





        return mapReturn;
    }

}

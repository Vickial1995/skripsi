package id.ac.budiluhur.absensifrontend.controller;

import com.google.gson.Gson;
import id.ac.budiluhur.absensifrontend.ArgonHashing;
import id.ac.budiluhur.absensifrontend.RestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {



    @GetMapping("/**")
    public String indexPage(){
        return "index";
    }

    @PostMapping("/pengajuan")
    public String ajukanAbsensi(@RequestParam String nip){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = currentDate.format(formatter);
        String sign = ArgonHashing.hash(nip+formatDateTime);

        HashMap<String,Object> object = new HashMap<>();
        object.put("nip",nip);
        object.put("checktime",formatDateTime);
        object.put("signature",sign);
        Gson gson = new Gson();

        String response = RestUtil.executeRest("http://localhost:8080/api/add_absensi",object);
        Map map = gson.fromJson(response, Map.class);

        System.out.println(map.get("status"));

        return "done";
    }

}

package id.ac.budiluhur.absensifrontend;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestUtil {

    public static String executeRest(String url, HashMap map){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("X-API-Key","B88TuNBpb64aIvZrit6Uw1wg84Ya0H0WaQ1XCo3y");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity,String.class);

        return response.getBody();
    }
}

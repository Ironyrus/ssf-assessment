package ssfassessment.cryptocompare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ssfassessment.cryptocompare.models.artObj;

public class NewsService {

    @Autowired
    artObj Articles;
    
    // @Value("${spring.crypto.password}")
    // private String crypto_apikey;
    private String crypto_apikey = System.getenv("CRYPTO_API_KEY");

    public ArrayList<artObj> getArticles() {
        StringBuilder url = new StringBuilder();
        url.append("https://min-api.cryptocompare.com/data/v2/news/?lang=EN&api_key=");
        url.append(crypto_apikey);

        RestTemplate template = new RestTemplate();
        RequestEntity<Void> request = RequestEntity
        .get(url.toString()).
        accept(MediaType.APPLICATION_JSON)
        .build();
        ResponseEntity<artObj> responseEntity = template.exchange(request, artObj.class);

        artObj articles = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());

        System.out.println("INSIDE SERVICE");
        for (int i = 0; i < articles.getData().size(); i++) {
            System.out.println(articles.getData().get(i));
        }
       
        return articles.getData();
    }

    public void saveArticles(List<Integer> valuesFromCheckbox, artObj articleObj, redisService service) {
        for (int i = 0; i < valuesFromCheckbox.size(); i++) {
            service.saveCurrObj(articleObj.getData().get((valuesFromCheckbox.get(i) - 1)), valuesFromCheckbox.get(i) - 1);

        }
    }
}

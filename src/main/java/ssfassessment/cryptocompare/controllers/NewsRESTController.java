package ssfassessment.cryptocompare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.Json;
import ssfassessment.cryptocompare.newsNotFoundException;
import ssfassessment.cryptocompare.models.artObj;
import ssfassessment.cryptocompare.services.redisService;

@RestController
public class NewsRESTController {
    
    @Autowired
    redisService service;

    @GetMapping("/news/{id}")
    public ResponseEntity getNews(@PathVariable String id) {

        // JsonObject body;
        try {
            artObj article = service.getCurrObj(id);
            if(article == null){
                throw new newsNotFoundException("");
            }
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(article);
        } catch (newsNotFoundException ex) {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("error", "Cannot find news article " + id);
            JsonObject body = builder.build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body.toString());
        }
    }
}

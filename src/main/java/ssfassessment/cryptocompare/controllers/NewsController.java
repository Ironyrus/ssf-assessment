package ssfassessment.cryptocompare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssfassessment.cryptocompare.models.artObj;
import ssfassessment.cryptocompare.services.NewsService;
import ssfassessment.cryptocompare.services.redisService;

@Controller
public class NewsController {
    
    @Autowired
    redisService service;

    artObj articleObj = new artObj();

    @GetMapping(path="/")
    public String getHome(Model model) {
        NewsService service = new NewsService(); 
        ArrayList<artObj> articles = new ArrayList<>();
        ArrayList<artObj> temp = new ArrayList<>();
        articles = service.getArticles();
        for (artObj article : articles) {
            temp.add(article);
        }

        //Populating object with Arraylist of articles
        articleObj.setData(temp);

        model.addAttribute("articles", articleObj);
        return "index";
    }

    @PostMapping("articles")
    public String getSuccess(Model model,
    @RequestParam("id") List<Integer> valuesFromCheckbox,
    @RequestParam("id") int id){

        NewsService newsService = new NewsService();
        newsService.saveArticles(valuesFromCheckbox, articleObj, service);

        model.addAttribute("articles", articleObj);
        return "index";
    }
}

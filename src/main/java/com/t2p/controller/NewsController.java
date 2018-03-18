package com.t2p.controller;

import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import com.t2p.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NewsController {
    @Autowired
    private INewsService newsService;

    @ModelAttribute("TypeOfNews")
    public List<TypeOfNews> allTypes() {
        return newsService.getAllTypes();
    }

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("news", compactAllNews(newsService.getAllNews()));
        return "indexPage";
    }

    @GetMapping("/{typeId}")
    public String newsInType(@PathVariable(name = "typeId") String typeId, Model model) {
        try {
            int id = Integer.parseInt(typeId);
            model.addAttribute("news", compactAllNews(newsService.getAllNewsByTypeId(id)));
        } catch (NumberFormatException e) {
            model.addAttribute("news", compactAllNews(newsService.getAllNews()));
        }
        return "indexPage";

    }

    @GetMapping("/news/{newsId}")
    public String newsaPage(@PathVariable("newsId") String newsId, Model model) {
        try {
            int id = Integer.parseInt(newsId);
            model.addAttribute("news", newsService.getNewsById(id));
        } catch (NumberFormatException e) {
        }
        return "newsPage";
    }

    List<News> compactAllNews(List<News> newsList){
        return newsList.stream().map(this::compactContent).collect(Collectors.toList());
    }

    News compactContent(News news) {
        if (news.getContent().length() >= 300)
            news.setContent(news.getContent().substring(0, 180));
        return news;
    }


}

package com.t2p.controller;

import com.a97lynk.controller.LoginController;
import com.a97lynk.object.entity.User;
import com.a97lynk.service.IUserService;
import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import com.t2p.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.accept.MediaTypeFileExtensionResolver;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class IcsseController {
    private static final Logger logger
            = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private INewsService newsService;

    // data cho navbar menu trên
    @ModelAttribute("NavMenu")
    public List<TypeOfNews> allMenus() {
        return newsService.getAllTypes().subList(0, 13);
    }

    @Autowired
    private IUserService userService;

    @ModelAttribute("news")
    public List<News> allNews() {
        return compactAllNews(newsService.getAllNewsByTypeId(14));
    }

    @ModelAttribute("user")
    public User login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userService.getUserByEmail(authentication.getName());
        }
        return null;
    }

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("topic", newsService.getNewsByUrl("home"));
        return "topicPage";
    }

    @GetMapping("/{url}")
    public String newsInType(@PathVariable(name = "url") String urlMenu, Model model) {
        try {
            News topic = newsService.getNewsByUrl(urlMenu);
            model.addAttribute("topic", topic);
            model.addAttribute("title", topic.getTypeOfNews().getType_name());
        } catch (Exception e) {
//            return "error/404";
        }
        return "topicPage";
    }

    @GetMapping("/news/{newsId}")
    public String newsaPage(@PathVariable("newsId") String newsId, Model model) {
        try {
            int id = Integer.parseInt(newsId);
            News news = newsService.getNewsById(id);
            List<News> listNews = allNews();
            listNews.remove(news);
            model.addAttribute("title", news.getTitle());
            model.addAttribute("anews", news);
            model.addAttribute("news", listNews);
        } catch (Exception e) {
//            return "redirect:/home";
        }
        return "newsPage";
    }

    @GetMapping("/edit/{url}")
    public String editPage(@PathVariable("url") String url, Model model) {
        try {
            News webPage = newsService.getNewsByUrl(url);
            model.addAttribute("title", webPage.getTypeOfNews().getType_name());
            model.addAttribute("topic", webPage);
        } catch (Exception e) {
//            return "redirect:/home";
        }
        return "editPage";
    }

    @PostMapping("/edit/{url}")
    public String submitChange(@PathVariable("url") String url, @RequestParam("content") String content, Model model) {
        try {
            News webPage = newsService.getNewsByUrl(url);
            webPage.setContent(content);
            newsService.changeEditWebPage(webPage);
            model.addAttribute("title", webPage.getTypeOfNews().getType_name());
            model.addAttribute("topic", webPage);
        } catch (Exception e) {
            return "redirect:/home";
        }
        return String.format("redirect:/%s", url);
    }


    List<News> compactAllNews(List<News> newsList) {
        return newsList.stream().map(this::compactContent).collect(Collectors.toList());
    }

    News compactContent(News news) {
        if (news.getContent().length() >= 200)
            news.setContent(news.getContent().substring(0, 180));
        return news;
    }


}

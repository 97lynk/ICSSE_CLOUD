package com.t2p.controller;

import com.a97lynk.springdrive.DriveController;
import com.t2p.entity.News;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;


@Controller
@RequestMapping({"/", ""})
public class TopicController extends IcsseController {

    @GetMapping
    public String index(Model model) {
        String s;
        model.addAttribute("topic", newsService.getNewsByUrl("home"));


        return "topicPage";
    }

    @RequestMapping("/{url}")
    public String newsInType(@PathVariable(name = "url") String urlMenu, Model model) {
        try {
            News topic = newsService.getNewsByUrl(urlMenu);
            model.addAttribute("topic", topic);
            model.addAttribute("title", topic.getTypeOfNews().getType_name());



        } catch (Exception e) {
            //return "error/404";
        }
        return "topicPage";
    }

    @GetMapping("/edit/{url}")
    @PreAuthorize("hasAuthority('WRITE_DATA')")
    public String editPage(@PathVariable("url") String url, Model model ) {
        try {
            News webPage = newsService.getNewsByUrl(url);
            model.addAttribute("title", webPage.getTypeOfNews().getType_name());
            model.addAttribute("topic", webPage);

        } catch (Exception e) {
//            return "redirect:/home";
        }
        return "editTopicPage";
    }

    @PostMapping("/edit/{url}")
    @PreAuthorize("hasAuthority('WRITE_DATA')")
    public String submitChange(@PathVariable("url") String url, @RequestParam("content") String content, Model model) {
        try {
            News webPage = newsService.getNewsByUrl(url);
            webPage.setContent(content);
            newsService.changeEditWebPage(webPage);
            model.addAttribute("title", webPage.getTypeOfNews().getType_name());
            model.addAttribute("topic", webPage);
             logger.log(Level.INFO, ">>> Edit web page (topic): {0} success", webPage.getTypeOfNews().getType_name());
        } catch (Exception e) {
            logger.log(Level.WARNING, ">>> Edit web page (topic): {0} failure", url);
            return "redirect:/home";
        }
        return String.format("redirect:/%s", url);
    }
}

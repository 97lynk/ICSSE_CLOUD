package com.t2p.controller;

import com.a97lynk.controller.LoginController;
import com.a97lynk.object.entity.User;
import com.a97lynk.service.IUserService;
import com.a97lynk.springdrive.DriveController;
import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import com.t2p.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class IcsseController {
    protected static final Logger logger
            = Logger.getLogger(IcsseController.class.getName());


    @Autowired
    protected INewsService newsService;

    @Autowired
    protected IUserService userService;

    // data cho navbar menu trên
    @ModelAttribute("NavMenu")
    public List<TypeOfNews> allMenus() {
        return newsService.getAllTypes().subList(0, 13);
    }

    // data cho aside news bên phải
    @ModelAttribute("news")
    public List<News> allNews() {
        return newsService.getAllNewsByTypeId(14).stream().sorted(new Comparator<News>() {
            @Override
            public int compare(News o1, News o2) {
                return (int) (o2.getCreateDate().getTime() - o1.getCreateDate().getTime());
            }
        }).collect(Collectors.toList());
    }

    // user hiện tại
    @ModelAttribute("user")
    public User login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userService.getUserByEmail(authentication.getName());
        }
        return null;
    }


    @ModelAttribute
    public void driveModel(Model model, HttpServletRequest req) {
        DriveController.listFile(req, model);
    }
}

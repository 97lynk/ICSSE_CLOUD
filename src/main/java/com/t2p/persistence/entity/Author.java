package com.t2p.persistence.entity;

import com.a97lynk.login.persistence.entity.User;

import javax.persistence.OneToMany;
import java.util.List;


public class Author extends User {

    @OneToMany(mappedBy = "user")
    private List<News> news;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

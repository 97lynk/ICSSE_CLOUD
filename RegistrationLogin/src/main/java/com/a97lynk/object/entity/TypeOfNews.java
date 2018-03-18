package com.a97lynk.object.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "types")
public class TypeOfNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int type_id;

    private String type_name;

    @OneToMany(mappedBy = "typeOfNews")
    private List<News> news;

    public TypeOfNews() {
    }

    public TypeOfNews(String type_name) {
        this.type_name = type_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

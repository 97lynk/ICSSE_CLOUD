package com.t2p.entity;

import com.a97lynk.object.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "type_id",
            insertable = false,
            updatable = false)
    private TypeOfNews typeOfNews;

    @ManyToOne
    @JoinColumn(name = "user_id",
            insertable = false,
            updatable = false)
    private User user;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Date createDate;

    private Date lastModified;

    public News() {
    }

    public News(String title, String content, Date createDate, Date lastModified) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastModified = lastModified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeOfNews getTypeOfNews() {
        return typeOfNews;
    }

    public void setTypeOfNews(TypeOfNews typeOfNews) {
        this.typeOfNews = typeOfNews;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("News [id = %d,%n title = %s,%n create = %s,%n last modified = %s,%n content = %s,%n user = %s,%n]",
                id, title,
                createDate, lastModified,
                content, user.getLastName());
    }
}

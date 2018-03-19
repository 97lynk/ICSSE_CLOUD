package com.t2p.service;

import com.t2p.entity.*;

import java.util.List;

public interface INewsService {

    News getNewsById(Integer id);

    News getNewsByUrl(String url);

    List<News> getAllNews();

    List<News> getAllNewsByType(TypeOfNews type);

    News changeEditWebPage(News webPage);

    List<News> getAllNewsByTypeId(Integer id);

    List<TypeOfNews> getAllTypes();
}

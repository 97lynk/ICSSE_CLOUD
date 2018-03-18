package com.t2p.service;

import com.t2p.entity.*;

import java.util.List;

public interface INewsService {

    News getNewsById(Integer id);

    List<News> getAllNews();

    List<News> getAllNewsByType(TypeOfNews type);

    List<News> getAllNewsByTypeId(Integer id);

    List<TypeOfNews> getAllTypes();
}

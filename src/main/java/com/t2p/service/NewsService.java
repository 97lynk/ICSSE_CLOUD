package com.t2p.service;

import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import com.t2p.repository.AuthorRepository;
import com.t2p.repository.NewsRepository;
import com.t2p.repository.TypeOfNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private TypeOfNewRepository typeOfNewRepository;

    @Override
    public News getNewsById(Integer id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public News getNewsByUrl(String url) {
        return newsRepository.findAllByUrl(url);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getAllNewsByType(TypeOfNews type) {
        return type.getNews();
    }

    @Override
    public News changeEditWebPage(News webPage) {
        return newsRepository.save(webPage);
    }

    @Override
    public List<News> getAllNewsByTypeId(Integer id) {
        return typeOfNewRepository.findById(id).get().getNews();
    }

    @Override
    public List<TypeOfNews> getAllTypes() {
        return typeOfNewRepository.findAll();
    }
}

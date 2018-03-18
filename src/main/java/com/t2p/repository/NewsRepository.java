package com.t2p.repository;

import com.t2p.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface NewsRepository extends JpaRepository<News, Integer>{
}

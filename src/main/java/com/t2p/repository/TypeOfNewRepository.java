package com.t2p.repository;

import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfNewRepository extends JpaRepository<TypeOfNews,Integer>{
}

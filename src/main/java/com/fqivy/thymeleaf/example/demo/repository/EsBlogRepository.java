package com.fqivy.thymeleaf.example.demo.repository;

import com.fqivy.thymeleaf.example.demo.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface EsBlogRepository extends ElasticsearchCrudRepository<EsBlog, Long> {
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content);
}

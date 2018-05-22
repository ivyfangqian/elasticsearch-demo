package com.fqivy.thymeleaf.example.demo.controller;

import com.fqivy.thymeleaf.example.demo.domain.EsBlog;
import com.fqivy.thymeleaf.example.demo.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class EsBlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam("title") String title,
                             @RequestParam("summary") String summary,
                             @RequestParam("content") String content,
                             @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);

        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        return page.getContent();

    }
}

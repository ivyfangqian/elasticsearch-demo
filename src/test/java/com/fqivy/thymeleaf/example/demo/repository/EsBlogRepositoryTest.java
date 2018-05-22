package com.fqivy.thymeleaf.example.demo.repository;

import com.fqivy.thymeleaf.example.demo.domain.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        //清除数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思", "床前明月光，疑是地上霜，举头望明月，低头思故乡"));
        esBlogRepository.save(new EsBlog("相思", "王维的相思", "红豆生南国，春来发几枝，愿君多采撷，此物最相思"));
        esBlogRepository.save(new EsBlog("江南春", "杜牧的江南春", "千里莺啼绿映红，水村山郭酒旗风，南朝四百八十寺，多少楼台烟雨中"));

    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "相思";

        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertEquals(2, page.getTotalElements());

        System.out.println("------------------start--1------");
        for (EsBlog esBlog : page.getContent()) {
            System.out.println(esBlog);
        }
        System.out.println("------------------end----1------");

        title = "相思";

        page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertEquals(1, page.getTotalElements());

        System.out.println("-----------------start--2-------");
        for (EsBlog esBlog : page.getContent()) {
            System.out.println(esBlog);
        }

        System.out.println("-----------------end----2--------");

    }
}
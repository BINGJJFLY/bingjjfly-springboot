package com.wjz.springboot.repository;

import com.wjz.springboot.domain.Article;
import com.wjz.springboot.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}

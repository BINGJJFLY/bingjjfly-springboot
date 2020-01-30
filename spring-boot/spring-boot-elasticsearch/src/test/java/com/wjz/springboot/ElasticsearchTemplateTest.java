package com.wjz.springboot;

import com.wjz.springboot.domain.Book;
import com.wjz.springboot.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ElasticsearchTemplateTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void index() {
        Book book = new Book();
        book.setId(7);
        book.setTitle("平凡的世界");
        book.setAuthor("路遥");
        book.setContent("平凡的人有不平凡的世界！");

        bookRepository.index(book);
    }
}

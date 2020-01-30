package com.wjz.springboot;

import com.wjz.springboot.domain.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class JestClientTest {

    @Autowired
    JestClient jestClient;

    @Test
    void jestClient_index() {
        Article article = new Article();
        article.setId("7");
        article.setTitle("平凡的世界观后感");
        article.setAuthor("路遥书迷");
        article.setContent("平凡的人有不平凡的世界。");

        // 创建索引
        Index index = new Index.Builder(article).index("bing").type("article").id("1").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void jestClient_search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"平凡\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder("").addIndex("bing").addType("books").build();

        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

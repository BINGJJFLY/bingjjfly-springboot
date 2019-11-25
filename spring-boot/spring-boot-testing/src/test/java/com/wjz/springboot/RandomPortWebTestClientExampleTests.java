package com.wjz.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 必须依赖 WebFlux
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomPortWebTestClientExampleTests {

    @Autowired
    private WebTestClient webClient;

    @LocalServerPort
    int port;

    @Test
    public void exampleTest() {
        System.out.println(port);
        this.webClient.get().uri("/index_1").exchange().expectStatus().isOk().expectBody(String.class)
                .isEqualTo("Success.");
    }
}

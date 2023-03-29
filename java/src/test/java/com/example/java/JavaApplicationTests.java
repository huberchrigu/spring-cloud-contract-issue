package com.example.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.cloud.contract.wiremock.restdocs.SpringCloudContractRestDocs.dslContract;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;

@SpringBootTest
@AutoConfigureWebTestClient
@AutoConfigureRestDocs
class JavaApplicationTests {
    private final WebTestClient webTestClient;

    JavaApplicationTests(@Autowired WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Test
    void contextLoads() {
        webTestClient.get()
                .exchange()
                .expectBody()
                .consumeWith(document("test", dslContract()));
    }
}

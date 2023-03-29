package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.restdocs.SpringCloudContractRestDocs.dslContract
import org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
@AutoConfigureRestDocs
class DemoApplicationTests(@Autowired private val webTestClient: WebTestClient) {

    @Test
    fun contextLoads() {
        webTestClient.get()
            .exchange()
            .expectBody()
            .consumeWith(document("test", dslContract()))
    }
}

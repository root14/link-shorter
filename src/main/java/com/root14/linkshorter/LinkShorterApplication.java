package com.root14.linkshorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class LinkShorterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkShorterApplication.class, args);
    }
}

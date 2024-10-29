package com.root14.linkshorter.controller;

import com.root14.linkshorter.core.UrlShortGenerator;
import com.root14.linkshorter.entity.Link;
import com.root14.linkshorter.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    LinkRepository linkRepository;

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Link>> findAll() {
        return ResponseEntity.ok(linkRepository.findAll());
    }

    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloWorld() {
        UrlShortGenerator generator = new UrlShortGenerator();
        String result = generator.generate();
        return ResponseEntity.ok("Hello World");
    }

}

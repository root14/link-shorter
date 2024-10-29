package com.root14.linkshorter.controller;

import com.root14.linkshorter.dto.LinkRequest;
import com.root14.linkshorter.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(value = "/shortLink", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createLink(@RequestBody LinkRequest linkRequest) {
        return linkService.shortLink(linkRequest);
    }

    @GetMapping("/url/{uniqueValue}")
    public void redirectLink(@PathVariable String uniqueValue, HttpServletResponse response) throws IOException {
        response.sendRedirect(linkService.getLongLink(uniqueValue));
    }
}

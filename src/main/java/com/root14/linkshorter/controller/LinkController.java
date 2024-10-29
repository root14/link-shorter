package com.root14.linkshorter.controller;

import com.root14.linkshorter.dto.LinkRequest;
import com.root14.linkshorter.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("shortLink")
    public ResponseEntity<String> createLink(@RequestBody LinkRequest linkRequest) {
        //return short link
        return linkService.shortLink(linkRequest);
    }

    @GetMapping("/{uniqueValue}")
    public void redirectLink(@PathVariable String uniqueValue, HttpServletResponse response) throws IOException {

        response.sendRedirect(linkService.getLongLink(uniqueValue));
    }
}

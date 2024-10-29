package com.root14.linkshorter.service;

import com.root14.linkshorter.core.UrlShortGenerator;
import com.root14.linkshorter.dto.LinkRequest;
import com.root14.linkshorter.entity.Link;
import com.root14.linkshorter.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private static final UrlShortGenerator urlShortGenerator = new UrlShortGenerator();

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public ResponseEntity<String> shortLink(LinkRequest linkRequest) {
        if (!linkRequest.getUrlPlain().startsWith("http://") && !linkRequest.getUrlPlain().startsWith("https://")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        String uniqueValue = urlShortGenerator.generate();

        Link link = linkRepository.findLinkByLinkLong(linkRequest.getUrlPlain());

        if (link != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(link.getUniqueValue());
        } else {
            link = Link.builder()
                    .linkLong(linkRequest.getUrlPlain())
                    .uniqueValue(uniqueValue)
                    .build();

            linkRepository.save(link);

            return ResponseEntity.status(HttpStatus.CREATED).body(baseUrl + link.getUniqueValue());
        }
    }

    //TODO handle exceptions by controller advice globally

    /**
     * using for redirect to plain url
     *
     * @param linkRequest
     * @return plain url.
     */
    public String getLongLink(LinkRequest linkRequest) {
        Link link = linkRepository.findLinkByLinkLong(linkRequest.getUrlPlain());

        return link.getLinkLong();
    }


    /**
     * using for redirect to plain url
     *
     * @param uniqueValue
     * @return plain url.
     */
    public String getLongLink(String uniqueValue) {
        Link link = linkRepository.findLinkByUniqueValue(uniqueValue);

        return link.getLinkLong();
    }
}

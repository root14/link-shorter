package com.root14.linkshorter.repository;

import com.root14.linkshorter.entity.Link;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LinkRepository extends ElasticsearchRepository<Link, String> {

    Link findLinkByLinkLong(String linkLong);

    Link findLinkByUniqueValue(String linkShort);

    Boolean existsLinkByLinkLong(String linkLong);
}

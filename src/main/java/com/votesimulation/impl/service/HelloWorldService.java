package com.votesimulation.impl.service;

import com.votesimulation.impl.entities.VoteSection;
import com.votesimulation.impl.repository.VoteSectionJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class HelloWorldService {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
    private VoteSectionJdbcRepository voteSectionJdbcRepository;

    @Autowired
    public HelloWorldService(VoteSectionJdbcRepository voteSectionJdbcRepository) {
        this.voteSectionJdbcRepository = voteSectionJdbcRepository;
    }

    public String getDesc() {

        logger.debug("getDesc() is executed!");

        return "Gradle + Spring MVC Hello World Example";

    }

    public String getTitle(String name) {

        logger.debug("getTitle() is executed! $name : {}", name);

        if (StringUtils.isEmpty(name)) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }

    }
    public List<VoteSection> getAllVotingSection() {
        //TO DO - use Hibernate JPA for mapping fields and table for the nex entity in play

        return voteSectionJdbcRepository.findAllVoteSections();
    }
}
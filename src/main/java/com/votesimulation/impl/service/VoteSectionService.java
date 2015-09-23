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
public class VoteSectionService {

    private static final Logger logger = LoggerFactory.getLogger(VoteSectionService.class);
    private VoteSectionJdbcRepository voteSectionJdbcRepository;

    @Autowired
    public VoteSectionService(VoteSectionJdbcRepository voteSectionJdbcRepository) {
        this.voteSectionJdbcRepository = voteSectionJdbcRepository;
    }

    public List<VoteSection> getAllVotingSection() {
        //TO DO - use Hibernate JPA for mapping fields and table for the nex entity in play

        return voteSectionJdbcRepository.findAllVoteSections();
    }
}
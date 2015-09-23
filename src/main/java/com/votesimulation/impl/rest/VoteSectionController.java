package com.votesimulation.impl.rest;

import com.votesimulation.impl.entities.VoteSection;
import com.votesimulation.impl.service.VoteSectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class VoteSectionController {

    private final Logger logger = LoggerFactory.getLogger(VoteSectionController.class);
    private final VoteSectionService voteSectionService;

    @Autowired
    public VoteSectionController(VoteSectionService voteSectionService) {
        this.voteSectionService = voteSectionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("route", "home");
        return "index";
    }



    @RequestMapping(value = "/loadAllVoteSections", method = RequestMethod.GET)
    public String showAllVoteSection(Map<String, Object> model) {
        model.put("route","allVoteSections");

        List<VoteSection> voteSectionList = voteSectionService.getAllVotingSection();
        logger.debug("showAllVoteSection() is exxecuted ");
        model.put("voteSectionList", voteSectionList);
        return "index";

    }

}
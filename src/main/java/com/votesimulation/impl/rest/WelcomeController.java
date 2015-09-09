package com.votesimulation.impl.rest;

import com.votesimulation.impl.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    public WelcomeController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        logger.debug("index() is executed!");

        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());

        //model.put("voteSectionArray", helloWorldService.getAllVotingSection());

        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name, Map<String, Object> model) {

        logger.debug("hello() is executed - $name {}", name);

        //ModelAndView model = new ModelAndView();
        //model.setViewName("index");

        model.put("title", helloWorldService.getTitle(name));
        model.put("msg", helloWorldService.getDesc());

        return "index";

    }

}
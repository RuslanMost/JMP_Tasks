package com.dabuita.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.Date;

@Controller
public class BookStoreController {

    @Autowired
    ServletContext servletContext;
    private static final Logger LOGGER = LogManager.getLogger(BookStoreController.class);

//    @RequestMapping(value = "/welcome/{name:.+}", method = RequestMethod.GET)
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView welcome() {
        String now = (new Date()).toString();
        LOGGER.info("Returning welcome view with " + now);

        return new ModelAndView("welcome", "now", now);
    }

}

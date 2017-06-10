package com.dabuita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
public class BookStoreController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String sayWelcome(final ModelMap model) {
//        model.addAttribute("message", "Welcome to our book store!");
//        return "welcome";
//    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public void  sayWelcome(HttpServletResponse response) throws IOException {
//        response.getWriter().println("ha-ha!");
//    }

    @Autowired
    ServletContext servletContext;


//    @RequestMapping(value = "/welcome/{name:.+}", method = RequestMethod.GET)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome__");
        model.addObject("msg", "something else");
        return model;
    }

}

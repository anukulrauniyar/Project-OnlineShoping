 package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
     @RequestMapping(value = {"/","home","/index"})
     
     public ModalAndView index() {
    	 ModelAndView mv = new ModelAndView("page");
    	 mv.addObject("getting","Welcome to Spring Web MVC");
    	 return mv;
     }
 }
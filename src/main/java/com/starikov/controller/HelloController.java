package com.starikov.controller;

import com.starikov.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private ContactDao contactDao;

    @RequestMapping(method = RequestMethod.GET)
    public String helloController(Model model) {
        model.addAttribute("name", contactDao.getContactById(1L));

        return "hello";
    }
}

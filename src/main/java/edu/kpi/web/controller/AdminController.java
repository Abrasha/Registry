package edu.kpi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Andrii Abramov on 19-May-16.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin_home", method = RequestMethod.GET)
    public String adminHome(@CookieValue("user_id") Integer id, Model model) {
        model.addAttribute("title", "Admin panel");
        return "admin_home";
    }

    @RequestMapping(value = "/add_new", method = RequestMethod.GET)
    public String addNew(Model model) {
        model.addAttribute("title", "Add new registry");
        return "add_new";
    }

}

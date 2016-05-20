package edu.kpi.web.controller;

import edu.kpi.repo.RegistryRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RegistryRepo registryRepo;

    @RequestMapping(value = "/admin_home", method = RequestMethod.GET)
    public String adminHome(@CookieValue("user_id") Integer id, Model model) {
        model.addAttribute("title", "Admin panel");
        return "admin_home";
    }

    @RequestMapping(value = "/registries", method = RequestMethod.GET)
    public String allRegistries(Model model) {
        model.addAttribute("title", "Admin panel");
        model.addAttribute("result", registryRepo.findAll());
        return "results";
    }

    @RequestMapping(value = "/add_new", method = RequestMethod.GET)
    public String addNew(Model model) {
        model.addAttribute("title", "Add new registry");
        return "add_new";
    }

}

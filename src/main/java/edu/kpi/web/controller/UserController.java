package edu.kpi.web.controller;

import edu.kpi.model.Registry;
import edu.kpi.repo.RegistryRepo;
import edu.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Andrii Abramov on 18-May-16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RegistryRepo registryRepo;


    @RequestMapping(value = "/user_registries", method = RequestMethod.GET)
    public String userRegistries(@CookieValue("user_id") Integer id, Model model) {

        final List<Registry> byPrincipalId = registryRepo.findByPrincipalId(id);
        model.addAttribute("regs", byPrincipalId);
        model.addAttribute("title", "My registries");

        return "user_registries";
    }


}

package edu.kpi.web.controller;

import edu.kpi.model.Person;
import edu.kpi.model.User;
import edu.kpi.repo.PersonRepo;
import edu.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Andrii Abramov on 19-May-16.
 */
@Controller
public class CommonController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonRepo personRepo;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Home page");
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, RedirectAttributes redirectAttributes, HttpServletResponse response) {

        final User currentUser = userService.findByLogin(user.getLogin());


        final String usersUrl = "redirect:/" +
                (currentUser.getAccountType() == User.AccountType.USER ?
                        "user_registries" : "admin_home");

        response.addCookie(new Cookie("user_id", String.valueOf(currentUser.getId())));

        redirectAttributes.addFlashAttribute("user", currentUser);
        return usersUrl;
    }

    @RequestMapping(value = "/people/{id}")
    public String showPerson(@PathVariable Integer id, Model model) {
        Person person = personRepo.findOne(id); // TODO check if null
        model.addAttribute("person", person);
        return "person";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {

        final ModelAndView mav = new ModelAndView("error");
        mav.addObject("exception", exception);
        mav.addObject("message", exception.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.addObject("title", "ERROR");
        return mav;
    }

}

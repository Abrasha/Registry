package edu.kpi.web.controller;

import edu.kpi.dto.NewRegistryDto;
import edu.kpi.model.Person;
import edu.kpi.model.Registry;
import edu.kpi.model.User;
import edu.kpi.repo.NotaryRepo;
import edu.kpi.repo.PersonRepo;
import edu.kpi.repo.PropertyRepo;
import edu.kpi.repo.RegistryRepo;
import edu.kpi.service.RegistryService;
import edu.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;

/**
 * @author Andrii Abramov on 19-May-16.
 */
@Controller
public class CommonController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Person.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(personRepo.findOne(Integer.valueOf(text)));
            }
        });
    }


    @Autowired
    private UserService userService;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private NotaryRepo notaryRepo;
    @Autowired
    private RegistryRepo registryRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private RegistryService registryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Home page");
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid User user, RedirectAttributes redirectAttributes, HttpServletResponse response) {

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

    @RequestMapping(value = "/new-registry", method = RequestMethod.GET)
    public ModelAndView addRegistry(Model model) {
        final ModelAndView mav = new ModelAndView("add_new");
        mav.addObject("registry", new NewRegistryDto());
        mav.addObject("people", personRepo.findAll());
        mav.addObject("notaries", notaryRepo.findAll());
        mav.addObject("properties", propertyRepo.findAll());
        return mav;
    }


    @RequestMapping(value = "/registries/{id}")
    public String showRegistry(@PathVariable Integer id, Model model) {
        Registry registry = registryRepo.findOne(id); // TODO check if null
        model.addAttribute("reg", registry);
        return "full_view";
    }


    @RequestMapping(value = "/registries", method = RequestMethod.POST)
    public String addNew(@ModelAttribute("registry") NewRegistryDto dto, Model model) {
        final Registry addedRegistry = registryService.parseRegistry(dto);
        model.addAttribute("reg", registryRepo.save(addedRegistry));
        return "full_view";
    }


    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        System.out.println(exception.getMessage());
        System.out.println(exception);
        exception.printStackTrace();
        final ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", exception.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.addObject("title", "ERROR");
        return mav;
    }

}

package edu.kpi.web.controller;

import edu.kpi.model.Registry;
import edu.kpi.repo.RegistryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrii Abramov on 19-May-16.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private RegistryRepo registryRepo;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(sdf, false));
    }

    @RequestMapping(value = "/by_date", method = RequestMethod.GET)
    public String byDate() {
        return "search_by_date";
    }

    @RequestMapping(value = "/by_date/res", method = RequestMethod.GET)
    public String byDateRes(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
                                    LocalDate dateOfRegistry, Model model) {
        final List<Registry> byDate = registryRepo.findByDate(dateOfRegistry);
        model.addAttribute("result", byDate);
        return "results";
    }

    @RequestMapping(value = "/by_principal", method = RequestMethod.GET)
    public String byPrincipal() {
        return "search_by_principal";
    }

    @RequestMapping(value = "/by_principal/res", method = RequestMethod.GET)
    public String byPrincipalRes(@RequestParam String principalName, Model model) {
        final List<Registry> byPrincipalName = registryRepo.findByPrincipalNameIgnoreCaseContaining(principalName);
        model.addAttribute("result", byPrincipalName);
        return "results";
    }

    @RequestMapping(value = "/by_series", method = RequestMethod.GET)
    public String bySeries() {
        return "search_by_series";
    }

    @RequestMapping(value = "/by_series/res", method = RequestMethod.GET)
    public String byPrincipalRed(@RequestParam String series, Model model) {
        final Registry bySeries = registryRepo.findOneBySeries(series);
        model.addAttribute("result", Arrays.asList(bySeries));
        return "results";
    }
}

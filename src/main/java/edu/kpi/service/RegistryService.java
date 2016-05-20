package edu.kpi.service;

import edu.kpi.dto.NewRegistryDto;
import edu.kpi.model.Person;
import edu.kpi.model.Registry;
import edu.kpi.repo.NotaryRepo;
import edu.kpi.repo.PersonRepo;
import edu.kpi.repo.PropertyRepo;
import edu.kpi.repo.RegistryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class RegistryService {

    @Autowired
    private RegistryRepo registryRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private NotaryRepo notaryRepo;

    public Registry parseRegistry(NewRegistryDto dto) {

        Registry registry = new Registry();
        registry.setNumber(dto.getNumber());
        registry.setNumberInActionList(dto.getNumberInActionList());
        registry.setSeries(dto.getSeries());
        registry.setDate(dto.getDate());
        registry.setIrrevocability(dto.getIrrevocabilty());
        registry.setDate(LocalDate.now());
        registry.setOther(dto.getOther());
        registry.setPrincipal(dto.getPrincipal());

        final List<Person> confs = Pattern.compile(",").splitAsStream(dto.getConfIDNs())
                .map(idn -> personRepo.findOnByCode(idn))
                .collect(Collectors.toList());

        registry.setConfidants(confs);
        registry.setNotary(dto.getNotary());
        registry.setProperty(dto.getProperty());


        return registry;
    }


}

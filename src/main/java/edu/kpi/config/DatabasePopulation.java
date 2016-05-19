package edu.kpi.config;

import edu.kpi.repo.*;
import edu.kpi.model.*;
import edu.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Andrii Abramov on 19-May-16.
 */
//@Configuration TODO - use when we need data population
public class DatabasePopulation {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private TownRepo townRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private NotaryRepo notaryRepo;
    @Autowired
    private RegistryRepo registryRepo;

    @PostConstruct
    private void init() {
        final User user1 = new User("login1", "asfsnkv", User.AccountType.USER);
        final User user2 = new User("login2", "asfsnkv", User.AccountType.USER);
        final User user3 = new User("login3", "asfsnkv", User.AccountType.ADMIN);
        final User user4 = new User("login4", "asfsnkv", User.AccountType.USER);
        final User user5 = new User("login5", "asfsnkv", User.AccountType.ADMIN);

        final Collection<User> addedUsers = userService.addUsers(
                Arrays.asList(user1, user2, user3, user4, user5)
        );

        final Region region = new Region("Kieeeevska oblast");
        final Region savedRegion = regionRepo.save(region);

        final Town town = new Town("Kiev", region);
        final Town savedTown = townRepo.save(town);

        final Notary notary = new Notary(Notary.NotaryType.STATE, town, "OOO XXX", "Some other information");
        final Notary savedNotary = notaryRepo.save(notary);

        final Person principal = new Person("Vasiliy", Person.PersonType.INDIVIDUAL, "CC123123", "Some descr1");
        final Person savedPerson = personRepo.save(principal);

        final Person confidant1 = new Person("Masha", Person.PersonType.ENTITY, "FF646348", "Some descr2");
        final Person savedConfidant1 = personRepo.save(confidant1);

        final Person confidant2 = new Person("Nadiya", Person.PersonType.INDIVIDUAL, "DF096636", "Some descr3");
        final Person savedConfidant2 = personRepo.save(confidant2);

        final Property property = new Property(Property.PropertyType.TRANSPORT, 235235, 2352351, "My first car :D");
        final Property savedProperty = propertyRepo.save(property);


        Registry toAdd = new Registry();
        toAdd.setDate(LocalDate.now());
        toAdd.setIrrevocability(null);
        toAdd.setNumberInActionList(4124);
        toAdd.setNumber(626234);
        toAdd.setOther("Other description");
        toAdd.setPrincipal(principal);
        toAdd.setSeries("pojmgpsmvspd;v");
        toAdd.setNotary(notary);
        toAdd.setConfidants(
                Arrays.asList(confidant1, confidant2)
        );
        toAdd.setProperty(property);

        final Registry savedRegistry = registryRepo.save(toAdd);

    }


}

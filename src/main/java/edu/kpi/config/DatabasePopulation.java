package edu.kpi.config;

import edu.kpi.model.*;
import edu.kpi.repo.*;
import edu.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Andrii Abramov on 19-May-16.
 */
//@Configuration
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
        final User user1 = new User("login1", "password1", User.AccountType.USER);
        final User user2 = new User("login2", "password2", User.AccountType.USER);
        final User user3 = new User("login3", "password3", User.AccountType.ADMIN);
        final User user4 = new User("login4", "password4", User.AccountType.USER);
        final User user5 = new User("login5", "password5", User.AccountType.ADMIN);

        final Collection<User> addedUsers = userService.addUsers(
                Arrays.asList(user1, user2, user3, user4, user5)
        );

        final Region region1 = new Region("Kievska oblast");
        final Region savedRegion1 = regionRepo.save(region1);
        final Region region2 = new Region("Lvivska oblast");
        final Region savedRegion2 = regionRepo.save(region2);
        final Region region3 = new Region("Kharkivska oblast");
        final Region savedRegion3 = regionRepo.save(region3);
        final Region region4 = new Region("Dnipropetrovska oblast");
        final Region savedRegion4 = regionRepo.save(region4);
        final Region region5 = new Region("Zaporizhska oblast");
        final Region savedRegion5 = regionRepo.save(region5);
        final Region region6 = new Region("Odeska oblast");
        final Region savedRegion6 = regionRepo.save(region6);

        final Town town1 = new Town("Kiev", region1);
        final Town savedTown1 = townRepo.save(town1);

        final Town town2 = new Town("Bila Tserkva", region1);
        final Town savedTown2 = townRepo.save(town2);

        final Town town3 = new Town("Lviv", region2);
        final Town savedTown3 = townRepo.save(town3);

        final Town town4 = new Town("Kharkiv", region3);
        final Town savedTown4 = townRepo.save(town4);

        final Town town5 = new Town("Dnipropetrovsk", region4);
        final Town savedTown5 = townRepo.save(town5);

        final Town town6 = new Town("Dniprodzerhinsk", region4);
        final Town savedTown6 = townRepo.save(town6);

        final Town town7 = new Town("Zaporizhya", region5);
        final Town savedTown7 = townRepo.save(town7);

        final Town town8 = new Town("Melitopol", region5);
        final Town savedTown8 = townRepo.save(town8);

        final Town town9 = new Town("Odesa", region6);
        final Town savedTown9 = townRepo.save(town9);

        final Notary notary1 = new Notary(Notary.NotaryType.STATE, town1, "OOO Horns and hoofs", "The best notary ");
        final Notary savedNotary1 = notaryRepo.save(notary1);

        final Notary notary2 = new Notary(Notary.NotaryType.STATE, town2, "OOO Shalom", "Great notary");
        final Notary savedNotary2 = notaryRepo.save(notary2);

        final Notary notary3 = new Notary(Notary.NotaryType.PRIVATE, town3, "OOO Notariussss", "So-so notary");
        final Notary savedNotary3 = notaryRepo.save(notary3);

        final Notary notary4 = new Notary(Notary.NotaryType.PRIVATE, town4, "Vano", "friendly notary");
        final Notary savedNotary4 = notaryRepo.save(notary4);

        final Notary notary5 = new Notary(Notary.NotaryType.PRIVATE, town5, "Kosoy", "strange notary");
        final Notary savedNotary5 = notaryRepo.save(notary5);

        final Notary notary6 = new Notary(Notary.NotaryType.STATE, town6, "Patriot notary", "good notary");
        final Notary savedNotary6 = notaryRepo.save(notary6);

        final Notary notary7 = new Notary(Notary.NotaryType.STATE, town7, "OOO Ukr-notary", "some info");
        final Notary savedNotary7 = notaryRepo.save(notary7);

        final Notary notary8 = new Notary(Notary.NotaryType.STATE, town8, "OOO Fast-Notary", "really fast");
        final Notary savedNotary8 = notaryRepo.save(notary8);

        final Notary notary9 = new Notary(Notary.NotaryType.PRIVATE, town9, "OOO Ivan-Notary", "reliable notary");
        final Notary savedNotary9 = notaryRepo.save(notary9);

        final Person principal1 = new Person("Ivanov Vasiliy Petrovich", Person.PersonType.INDIVIDUAL, "98123123", "Driver");
        final Person savedPerson1 = personRepo.save(principal1);

        final Person principal2 = new Person("Kharchenko Ivan Opanasovich ", Person.PersonType.INDIVIDUAL, "98763123", "Builder");
        final Person savedPerson2 = personRepo.save(principal2);

        final Person principal3 = new Person("Petrenko Olga Ivanovna ", Person.PersonType.INDIVIDUAL, "98763555", "Teatcher");
        final Person savedPerson3 = personRepo.save(principal3);

        final Person principal4 = new Person("Syvukha Nazar Oleksandrovych ", Person.PersonType.INDIVIDUAL, "98720555", "Artist");
        final Person savedPerson4 = personRepo.save(principal4);

        final Person confidant1 = new Person("OAO WOLF", Person.PersonType.ENTITY, "12646348", "Some descr2");
        final Person savedConfidant1 = personRepo.save(confidant1);

        final Person confidant2 = new Person("Sydorova Nadiya Olegivna", Person.PersonType.INDIVIDUAL, "14096636", "Some descr3");
        final Person savedConfidant2 = personRepo.save(confidant2);

        final Person confidant3 = new Person("Starikov Stepan Andriyovich", Person.PersonType.INDIVIDUAL, "14088836", "Some descr3");
        final Person savedConfidant3 = personRepo.save(confidant3);

        final Property property1 = new Property(Property.PropertyType.TRANSPORT, 216535, 2358787, "Shevrolet aveo");
        final Property savedProperty1 = propertyRepo.save(property1);

        final Property property2 = new Property(Property.PropertyType.TRANSPORT, 235432, 1012351, "Lada sedan");
        final Property savedProperty2 = propertyRepo.save(property2);

        final Property property3 = new Property(Property.PropertyType.OTHER, 254235, 2767751, "Office Building");
        final Property savedProperty3 = propertyRepo.save(property3);

        final Property property4 = new Property(Property.PropertyType.OTHER, 239835, 2351114, "Garage");
        final Property savedProperty4 = propertyRepo.save(property4);

        final Property property5 = new Property(Property.PropertyType.TRANSPORT, 235209, 2352769, "Toyota Camry");
        final Property savedProperty5 = propertyRepo.save(property5);

        final Property property6 = new Property(Property.PropertyType.OTHER, 235235, 2352351, "Village");
        final Property savedProperty6 = propertyRepo.save(property6);


        Registry toAdd1 = new Registry();
        toAdd1.setDate(LocalDate.now());
        toAdd1.setIrrevocability(null);
        toAdd1.setNumberInActionList(4114);
        toAdd1.setNumber(626234);
        toAdd1.setOther("Other description");
        toAdd1.setPrincipal(principal1);
        toAdd1.setSeries("TT");
        toAdd1.setNotary(notary6);
        toAdd1.setConfidants(
                Arrays.asList(confidant1)
        );
        toAdd1.setProperty(property5);

        final Registry savedRegistry1 = registryRepo.save(toAdd1);

        Registry toAdd2 = new Registry();
        toAdd2.setDate(LocalDate.of(2016, Month.MARCH, 21));
        toAdd2.setIrrevocability(null);
        toAdd2.setNumberInActionList(4124);
        toAdd2.setNumber(123456);
        toAdd2.setOther("no description");
        toAdd2.setPrincipal(principal2);
        toAdd2.setSeries("PK");
        toAdd2.setNotary(notary4);
        toAdd2.setConfidants(Arrays.asList(confidant2, confidant3));
        toAdd2.setProperty(property3);

        final Registry savedRegistry2 = registryRepo.save(toAdd2);

        Registry toAdd3 = new Registry();
        toAdd3.setDate(LocalDate.of(2016, Month.APRIL, 21));
        toAdd3.setIrrevocability(null);
        toAdd3.setNumberInActionList(4127);
        toAdd3.setNumber(129854);
        toAdd3.setOther("no description");
        toAdd3.setPrincipal(principal3);
        toAdd3.setSeries("FM");
        toAdd3.setNotary(notary2);
        toAdd3.setConfidants(Arrays.asList(confidant1));
        toAdd3.setProperty(property2);

        final Registry savedRegistry3 = registryRepo.save(toAdd3);

        Registry toAdd4 = new Registry();
        toAdd4.setDate(LocalDate.of(2016, Month.MAY, 17));
        toAdd4.setIrrevocability(null);
        toAdd4.setNumberInActionList(4087);
        toAdd4.setNumber(823754);
        toAdd4.setOther("no description");
        toAdd4.setPrincipal(principal4);
        toAdd4.setSeries("PP");
        toAdd4.setNotary(notary5);
        toAdd4.setConfidants(Arrays.asList(confidant3));
        toAdd4.setProperty(property6);

        final Registry savedRegistry4 = registryRepo.save(toAdd4);


        Registry toAdd5 = new Registry();
        toAdd5.setDate(LocalDate.of(2016, Month.MAY, 10));
        toAdd5.setIrrevocability(null);
        toAdd5.setNumberInActionList(4071);
        toAdd5.setNumber(823101);
        toAdd5.setOther("no description");
        toAdd5.setPrincipal(principal4);
        toAdd5.setSeries("PL");
        toAdd5.setNotary(notary8);
        toAdd5.setConfidants(Arrays.asList(confidant3, confidant1));
        toAdd5.setProperty(property4);

        final Registry savedRegistry5 = registryRepo.save(toAdd5);
    }


}

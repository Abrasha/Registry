package edu.kpi;

import edu.kpi.repo.*;
import edu.kpi.model.*;
import edu.kpi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Abrasha on 29-Apr-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(KpzProjectApplication.class)
public class TestInsertions {

    @Autowired
    private UserService userService;
    @Autowired
    private RegistryRepo registryRepo;
    @Autowired
    private NotaryRepo notaryRepo;
    @Autowired
    private TownRepo townRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PropertyRepo propertyRepo;

    @Test
    public void testUserInsertion() {
        User toAdd1 = new User("qwerty", "pass1", User.AccountType.ADMIN);
        assertNull(toAdd1.getId());
        userService.addUser(toAdd1);
        assertNotNull(toAdd1.getId());

        User toAdd2 = new User("asdfgh", "pass2", User.AccountType.ADMIN);
        assertNull(toAdd2.getId());
        userService.addUser(toAdd2);
        assertNotNull(toAdd2.getId());

        User toAdd3 = new User("zxcxcv", "pass3", User.AccountType.ADMIN);
        assertNull(toAdd3.getId());
        userService.addUser(toAdd3);
        assertNotNull(toAdd3.getId());

        User toAdd4 = new User("jgfsdf", "pass4", User.AccountType.ADMIN);
        assertNull(toAdd4.getId());
        userService.addUser(toAdd4);
        assertNotNull(toAdd4.getId());
    }


    @Test
    public void testRegistryInsertion() {

            final Region region = new Region("Kieeeevska oblast");
            final Region savedRegion = regionRepo.save(region);
            assertNotNull(savedRegion.getId());

            final Town town = new Town("Kiev", region);
            final Town savedTown = townRepo.save(town);
            assertNotNull(savedTown.getId());

            final Notary notary = new Notary(Notary.NotaryType.STATE, town, "OOO XXX", "Some other information");
            final Notary savedNotary = notaryRepo.save(notary);
            assertNotNull(savedNotary.getId());

            final Person principal = new Person("sjdsdjlkvn23", Person.PersonType.INDIVIDUAL, "Andrew", "wongpioweng");
            final Person savedPerson = personRepo.save(principal);
            assertNotNull(savedPerson.getId());

            final Person confidant1 = new Person("sjdsdjlkvn23", Person.PersonType.INDIVIDUAL, "confidant1", "rpgmsdkmb");
            final Person savedConfidant1 = personRepo.save(confidant1);
            assertNotNull(savedConfidant1.getId());

            final Person confidant2 = new Person("sjdsdjlkvn23", Person.PersonType.INDIVIDUAL, "confidant2", "lksenf");
            final Person savedConfidant2 = personRepo.save(confidant2);
            assertNotNull(savedConfidant2.getId());

            final Property property = new Property(Property.PropertyType.TRANSPORT, 235235, 2352351, "sldfmosdmg");
            final Property savedProperty = propertyRepo.save(property);
            assertNotNull(savedProperty.getId());


            Registry toAdd = new Registry();
            assertNull(toAdd.getId());
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
            assertNotNull(savedRegistry.getId());

    }
}

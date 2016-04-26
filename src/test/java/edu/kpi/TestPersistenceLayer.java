package edu.kpi;


import edu.kpi.dao.*;
import edu.kpi.model.*;

import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPersistenceLayer {


    static ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @AfterClass
    public static void tearDown() {
        context.close();
    }

    @Test
    public void testUserDao() {

        AccTypeDAO accTypeDAO = (AccTypeDAO) context.getBean("accTypeDAO");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        final AccountType accountType = new AccountType("MASTER");

        final User user = new User();
        user.setLogin("misha");
        user.setPassword("hispasswrd");

        assertNull(accountType.getId());
        assertNull(user.getId());

        final AccountType addedAccType = accTypeDAO.save(accountType);

        assertNotNull(addedAccType);
        assertNotNull(addedAccType.getId());


        user.setAccountType(addedAccType);
        final User addedUser = userDAO.save(user);
        assertNotNull(addedUser);
        assertNotNull(addedUser.getId());

    }

    @Test
    public void testRegionTownDAO() {
        RegionDAO regionDAO = (RegionDAO) context.getBean("regionDAO");
        TownDAO townDAO = (TownDAO) context.getBean("townDAO");

        final Region region = new Region("Kievska obl");

        final Town town = new Town();
        town.setName("Kiev");

        assertNull(region.getId());
        assertNull(town.getId());

        final Region addedRegion = regionDAO.save(region);

        assertNotNull(addedRegion);
        assertNotNull(addedRegion.getId());

        town.setRegion(addedRegion);
        final Town addedTown = townDAO.save(town);
        assertNotNull(addedTown);
        assertNotNull(addedTown.getId());


    }

    @Test
    public void testPropertyAndTypeDAO() {
        PropertyTypeDAO prtypeDAO = (PropertyTypeDAO) context.getBean("propertyTypeDAO");
        PropertyDAO propertyDAO = (PropertyDAO) context.getBean("propertyDAO");

        final PropertyType type = new PropertyType("Vehicle");

        final Property property = new Property();
        property.setPropertyType(type);
        property.setDescription("Lada Sedan");
        property.setRegistrationNumber(123456);
        property.setSerialNumber(111111);

        assertNull(type.getId());
        assertNull(property.getId());

        final PropertyType addedType = prtypeDAO.save(type);

        assertNotNull(addedType);
        assertNotNull(addedType.getId());

        property.setPropertyType(addedType);
        final Property addedProperty = propertyDAO.save(property);
        assertNotNull(addedProperty);
        assertNotNull(addedProperty.getId());


    }


    @Test
    public void testPersonAndTypeDAO() {
        PersonTypeDAO ptypeDAO = (PersonTypeDAO) context.getBean("personTypeDAO");
        PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");

        final PersonType type = new PersonType("individual");

        final Person person = new Person();
        person.setCode("666999");
        person.setName("Stepan Sraka");
        person.setOther("engineer");


        assertNull(type.getId());
        assertNull(person.getId());

        final PersonType AddedType = ptypeDAO.save(type);

        assertNotNull(AddedType);
        assertNotNull(AddedType.getId());

        person.setPersonType(AddedType);
        final Person AddedPerson = personDAO.save(person);
        assertNotNull(AddedPerson);
        assertNotNull(AddedPerson.getId());


    }

    @Test
    public void testNotaryAndTypeDAO() {
        NotaryTypeDAO ntypeDAO = (NotaryTypeDAO) context.getBean("notaryTypeDAO");
        NotaryDAO notaryDAO = (NotaryDAO) context.getBean("notaryDAO");

        TownDAO townDAO = (TownDAO) context.getBean("townDAO");

        final NotaryType type = new NotaryType("State");

        final Notary notary = new Notary();
        notary.setInfo("Test notary");
        notary.setOrganisation("Horns and hoofs");

        // it is Kiev
        Town town = townDAO.getOne(6);
        assertNotNull(town);
        assertNotNull(town.getId());
        notary.setTown(town);


        assertNull(type.getId());
        assertNull(notary.getId());

        final NotaryType AddedType = ntypeDAO.save(type);

        assertNotNull(AddedType);
        assertNotNull(AddedType.getId());

        notary.setNotaryType(AddedType);
        final Notary AddedNotary = notaryDAO.save(notary);
        assertNotNull(AddedNotary);
        assertNotNull(AddedNotary.getId());


    }


}

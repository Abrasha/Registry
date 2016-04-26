package edu.kpi;


import edu.kpi.dao.AccTypeDAO;
import edu.kpi.dao.RegionDAO;
import edu.kpi.dao.TownDAO;
import edu.kpi.dao.UserDAO;
import edu.kpi.model.AccountType;
import edu.kpi.model.Region;
import edu.kpi.model.Town;
import edu.kpi.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPersistenceLayer {


    ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @After
    public void tearDown() {
        context.close();
    }

    //    @Test
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


}

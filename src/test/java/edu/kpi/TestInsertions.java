package edu.kpi;

import edu.kpi.model.Registry;
import edu.kpi.model.User;
import edu.kpi.service.RegistryService;
import edu.kpi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    private RegistryService registryService;

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

}

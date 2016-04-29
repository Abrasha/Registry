package edu.kpi;

import edu.kpi.dao.UserRepo;
import edu.kpi.model.User;
import edu.kpi.service.PersonService;
import edu.kpi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KpzProjectApplication.class)
@Transactional
@Rollback
public class KpzProjectApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testRead() {
        assertTrue(userService.getAllUsers().size() > 0);
    }

    @Test
    public void testInsert() {
        final User toAdd = new User("login1", "login2", User.AccountType.USER);

        assertNull(toAdd.getId());

        final User added = userService.addUser(toAdd);
        assertNotNull(added);
        assertNotNull(added.getId());
    }

    @Test
    public void testRemove() {
        final List<User> users = userService.getAllUsers();
        assertTrue(users.size() > 0);

        final User toDelete = users.get(0);
        Integer idToCheck = toDelete.getId();
        assertTrue(userService.deleteUser(toDelete));
        assertNull(userService.findUser(idToCheck));
    }

    @Test
    public void testCustomQueries() {
        userService.addUser(new User("login2", "asfsnkv", User.AccountType.USER));
        userService.addUser(new User("login3", "asfsnkv", User.AccountType.ADMIN));
        userService.addUser(new User("login4", "asfsnkv", User.AccountType.USER));
        userService.addUser(new User("login5", "asfsnkv", User.AccountType.ADMIN));

        assertTrue(userRepo.findByAccountType(User.AccountType.USER).size() > 0);
        System.out.println(userRepo.findByAccountType(User.AccountType.USER).size());
    }

}

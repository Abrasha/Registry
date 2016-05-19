package edu.kpi;

import edu.kpi.model.User;
import edu.kpi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrii Abramov on 19-May-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KpzProjectApplication.class)
@Transactional
@Rollback
public class LittleTests {

    @Autowired
    UserService userService;

    @Test
    public void testByLogin(){
        final User user = userService.findByLogin("login1");
        System.out.println(user);
    }
}

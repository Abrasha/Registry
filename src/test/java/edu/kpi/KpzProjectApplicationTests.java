package edu.kpi;

import edu.kpi.dao.RegionDAO;
import edu.kpi.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KpzProjectApplication.class)
@Transactional
public class KpzProjectApplicationTests {

    @Autowired
    UserDAO userDAO;
    @Autowired
    RegionDAO regionDAO;

    @Test
    public void contextLoads() {

        System.out.println(userDAO.findAll());

    }

}

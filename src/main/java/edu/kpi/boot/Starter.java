package edu.kpi.boot;

import edu.kpi.model.*;
import edu.kpi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Starter {

    @Autowired
    UserService userService;


    public static void main(String[] args) {


        Starter starter = new Starter();
        starter.test();

    }

    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");

        UserService service = context.getBean(UserService.class);

        AccountType type = new AccountType("MASTER");
        service.addAccountType(type);
        User user = new User("login", "pass", type);
        service.addUser(user);
        System.out.println(user.getId());
        Region region =new Region("Dnipropetrovska oblast");
        service.addRegion(region);
        Town town = new Town("Krivy Rig",region);
        service.addTown(town);
        System.out.println(town.getId()+" " +town.getName());
    }

}

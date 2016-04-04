package edu.kpi.boot;

import edu.kpi.dao.AccTypeDAO;
import edu.kpi.dao.UserDAO;
import edu.kpi.model.AccountType;
import edu.kpi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Abrasha on 01-Apr-16.
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AccTypeDAO accTypeDAO;

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public AccountType addAccountType(AccountType accType) {
        return accTypeDAO.save(accType);
    }


}

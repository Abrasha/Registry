package edu.kpi.dao;


import edu.kpi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findOnByLogin(String login);

    List<User> findByAccountType(User.AccountType accountType);

}

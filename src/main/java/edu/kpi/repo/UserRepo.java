package edu.kpi.repo;


import edu.kpi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByAccountType(User.AccountType accountType);

    User findOneByLogin(String login);

}

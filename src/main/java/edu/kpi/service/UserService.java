package edu.kpi.service;

import edu.kpi.dao.UserRepo;
import edu.kpi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User findUser(Integer id) {
        return userRepo.findOne(id);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public boolean deleteUser(User user) {
        Integer toRemove = user.getId();
        userRepo.delete(toRemove);
        return userRepo.exists(toRemove);
    }

    public boolean deleteUser(Integer id) {
        userRepo.delete(id);
        return userRepo.exists(id);
    }

    public boolean userExists(Integer id) {
        return userRepo.exists(id);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}

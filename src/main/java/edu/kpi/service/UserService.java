package edu.kpi.service;

import edu.kpi.repo.UserRepo;
import edu.kpi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public Collection<User> addUsers(Collection<User> users) {
        return users.stream()
                .map(userRepo::save)
                .collect(Collectors.toList());
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

    public User findByLogin(String login) {
        return userRepo.findOneByLogin(login);
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

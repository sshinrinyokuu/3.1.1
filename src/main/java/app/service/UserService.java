package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    void saveUser(String name, String lastName, String nationality);
    void deleteUser(Long id);
    void editUser(Long id, String name, String lastName, String nationality);
    List<User> showUsers();
}
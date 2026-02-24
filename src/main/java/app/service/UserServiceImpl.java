package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void saveUser(String name, String lastName, String nationality) {
        userDao.saveUser(name, lastName, nationality);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void editUser(Long id, String name, String lastName, String nationality) {
        userDao.editUser(id, name, lastName, nationality);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }
}
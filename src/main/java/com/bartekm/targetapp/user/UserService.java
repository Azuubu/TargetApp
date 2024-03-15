package com.bartekm.targetapp.user;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User findUserById(int id);

    User updateUser(User user);

    Boolean deleteById(int id);
}

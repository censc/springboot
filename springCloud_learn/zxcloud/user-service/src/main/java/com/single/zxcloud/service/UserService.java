package com.single.zxcloud.service;


import com.single.zxcloud.domain.User;

import java.util.List;

public interface UserService {
    void create(User user);
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByName(String username);
    List<User> getListByIds(List<Long> ids);
}

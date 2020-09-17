package com.single.zxcloud.service.impl;

import com.single.zxcloud.domain.User;
import com.single.zxcloud.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private List<User> userList;
    
    @Override
    public void create(User user){
        userList.add(user);
    }
    
    @Override
    public User getUser(Long id){
        List<User> findUserList = userList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }
    
    @Override
    public void updateUser(User user){
        userList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
            userItem.setUserName(user.getUserName());
            userItem.setPassword(user.getPassword());
        });
    }
    
    @Override
    public void deleteUser(Long id){
        User user = getUser(id);
        if (user != null) {
            userList.remove(user);
        }
    }
    
    @Override
    public User getUserByName(String username){
        List<User> findUserList = userList.stream().filter(userItem -> userItem.getUserName().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }
    
    @Override
    public List<User> getListByIds(List<Long> ids){
        return userList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }
    
    @PostConstruct
    public void initData(){
        userList = new ArrayList<>();
        userList.add(new User(1L, "zhangsan", "123456"));
        userList.add(new User(2L, "zhuangsan", "123456"));
        userList.add(new User(3L, "zhangsuan", "123456"));
        System.out.println("加入了三个初始人物");
    }
    
}

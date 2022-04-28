package com.xisen.serviceprovider8001;

import com.xisen.userserviceapi.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService{

    public User getById(String id) {
        User user = new User();
        user.setId(id);
        user.setName("张三");
        return user;
    }

    public User addUser(User user) {
        System.out.println(user);
        return user;
    }
}

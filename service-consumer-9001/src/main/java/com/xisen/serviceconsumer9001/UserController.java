package com.xisen.serviceconsumer9001;


import com.xisen.userserviceapi.User;
import com.xisen.userserviceapi.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController{

    @Autowired
    UserService userService;


    @GetMapping(value = "getById")
    public User getById(String id) {
        return userService.getById(id);
    }

    /**
     * 注意post请求参数需要添加@RequestBody，否则无法接收参数
     * @param user
     * @return
     */
    @PostMapping(value = "addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}

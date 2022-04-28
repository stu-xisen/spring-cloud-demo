package com.xisen.serviceprovider8001;


import com.xisen.userserviceapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController{

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "isAlive")
    public String isAlive(){
        return "ok";
    }


    @GetMapping(value = "/getById")
    public User getById(@RequestParam(name = "id") String id) {
        return userService.getById(id);
    }


    /**
     * 注意post请求参数需要添加@RequestBody，否则无法接收参数
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}

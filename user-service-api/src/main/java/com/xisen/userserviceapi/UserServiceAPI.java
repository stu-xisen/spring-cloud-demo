package com.xisen.userserviceapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserServiceAPI {

    /**
     * 此处必须添加@RequestParam注解，目的是声明给Feign，发送请求的时候要带参数
     * @param id
     * @return
     */
    @GetMapping(value = "/user/getById")
    public User getById(@RequestParam(name = "id") String id);
    @PostMapping(value = "/user/addUser")
    public User addUser(User user);
}

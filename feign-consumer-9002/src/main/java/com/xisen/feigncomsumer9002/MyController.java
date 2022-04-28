package com.xisen.feigncomsumer9002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @Autowired
    MyService myService;


    @GetMapping("hello")
    public String hello(){
        return myService.hello();
    }

    @GetMapping("hello2")
    public String hello2(String name){
        return myService.hello2(name);
    }

    @GetMapping("hello3/{name}")
    public String hello3(@PathVariable("name") String name){
        return myService.hello3(name);
    }
}

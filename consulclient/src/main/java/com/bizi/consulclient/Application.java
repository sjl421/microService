package com.bizi.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by guofangbi on 2016/12/27.
 */
@RestController
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String hello(String name){
        return helloService.sayHello(name);
    }
    @RequestMapping("/dataTrans")
    public UserDTO dataTrans(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(123);
        userDTO.setUsername("guofangbi");
        userDTO.setBirthday(new Date());
        return helloService.dataTrans(userDTO);
    }
}
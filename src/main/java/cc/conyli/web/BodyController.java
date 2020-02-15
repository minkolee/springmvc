package cc.conyli.web;

import cc.conyli.entity.Address;
import cc.conyli.entity.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BodyController {


    @RequestMapping("/user")
    public User getUser() {
        User user = new User();
        Address address = new Address();
        address.setDetail("zhr");
        user.setAddress(address);
        user.setAge(6);
        user.setUserName("cony");
        return user;
    }

    @RequestMapping("/acceptuser")
    public String getUser(@RequestBody(required = false) User user) {
        System.out.println("接受到的JSON转换成的是: " + user);
        return "index";
    }
}

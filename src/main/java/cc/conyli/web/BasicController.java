package cc.conyli.web;

import cc.conyli.entity.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

//@Controller
@SessionAttributes("user")
public class BasicController {

    @RequestMapping("/test")
    public String home(@ModelAttribute("user") User user) {
        return "index";
    }

//    @ModelAttribute("modelUser")
//    public User getUser() {
//        User user = new User();
//        user.setAge(10);
//        return user;
//    }

}

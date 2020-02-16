package cc.conyli.web;

import cc.conyli.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class LoginController {

    @RequestMapping("/form")
    public String login() {
        return "login";
    }


    //每次访问控制器都生成一个新的User对象放入到模型中
    @ModelAttribute("user")
    public User generateUser() {
        return new User();
    }

    @PostMapping("/login")
    public String validateUser(@ModelAttribute("user") User user) {
        System.out.println("方法的入参对象是: " + user);
        return "redirect:/test";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/test";
    }
}

package cc.conyli.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class BasicController {

    @RequestMapping
    public String home() {
        System.out.println("控制器方法生效");
        return "index";
    }

}

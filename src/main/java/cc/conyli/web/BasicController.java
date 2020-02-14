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

@Controller
public class BasicController {

    @RequestMapping("/")
    public String home() {
        System.out.println("控制器方法生效");
        return "index";
    }


    @RequestMapping("/image")
    public void image(OutputStream outputStream) throws IOException {
        Resource file = new FileSystemResource("C:\\Users\\Minko\\Pictures\\mhwi.jpg");
        FileCopyUtils.copy(file.getInputStream(), outputStream);
    }

    @ResponseBody
    @RequestMapping("/byteimage")
    public byte[] image(HttpServletResponse response) throws IOException {
        Resource file = new FileSystemResource("C:\\Users\\Minko\\Pictures\\mhwi2.jpg");
        return FileCopyUtils.copyToByteArray(file.getInputStream());
    }


    @RequestMapping("/usercreate")
    public ModelAndView createUser(@RequestBody User user) {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}

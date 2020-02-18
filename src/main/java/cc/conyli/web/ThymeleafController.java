package cc.conyli.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ThymeleafController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        file.transferTo(new File("d:\\temp\\" + file.getOriginalFilename()));
        return "index";
    }

}

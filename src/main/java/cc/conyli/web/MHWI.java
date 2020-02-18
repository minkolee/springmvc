package cc.conyli.web;

import cc.conyli.entity.Velkhana;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

//@Controller
@RequestMapping("/mhwi")
public class MHWI {

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/form2")
    public String form2() {
        return "form2";
    }

    @ModelAttribute("vel")
    public Velkhana getVel() {
        return new Velkhana();
    }

    @PostMapping("/add")
    public String getVelkhana(@Valid @ModelAttribute("vel") Velkhana velkhana, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            for (FieldError e : bindingResult.getFieldErrors()) {
                System.out.println(e.getField() + e.getDefaultMessage() + " 错误的值是: " + e.getRejectedValue());
            }
            return "form";
        }
        System.out.println("传入的冰呪龙对象是: " + velkhana);
        return "index";
    }

    @PostMapping("/add2")
    public String getVelkhana2(@Valid @ModelAttribute("vel") Velkhana velkhana, BindingResult bindingResult, Map<String, Object> map) {
        System.out.println("传入的冰呪龙对象是: " + velkhana);

        if (bindingResult.hasErrors()) {
            for (FieldError e : bindingResult.getFieldErrors()) {
                System.out.println(e.getField() + e.getDefaultMessage() + " 错误的值是: " + e.getRejectedValue());
                map.put(e.getField() + "Error", e.getDefaultMessage());
            }
            return "form2";
        }
        return "index";
    }
}

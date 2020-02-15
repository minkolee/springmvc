package cc.conyli.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.BindException;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/model")
public class ModelController {

    @RequestMapping("/nodata")
    public ModelAndView noData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/view")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test","这是测试信息");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ModelAttribute("time")
    public String getCurrentTimeString() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.toString();
    }

    @RequestMapping("/map")
    public String testModelMap(Map<String, Object> map) {
        System.out.println("模型数据是: " + map);
        System.out.println("修改时间");
        map.replace("time", "新修改的时间");
        return "index";
    }


}

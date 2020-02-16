package cc.conyli.web;

import cc.conyli.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/add")
    public String addSessionData(HttpServletRequest request, HttpSession session) {

        request.setAttribute("setinrequest", "cony");
        session.setAttribute("setinsession", "owl");

        return "redirect:/session/find";
    }

    @RequestMapping("/add2")
    public String addSessionData2(HttpServletRequest request, HttpSession session) {

        request.setAttribute("setinrequest", "cony");
        session.setAttribute("setinsession", "owl");

        return "forward:/session/find";
    }

    @RequestMapping("/find")
    public ModelAndView testFindDataFromSesssion(HttpServletRequest request, HttpSession session) {

        System.out.println("从request中获取: "+request.getAttribute("setinrequest"));
        System.out.println("从session中获取: "+session.getAttribute("setinsession"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("setbycontroller", "kiki");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}

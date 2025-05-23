package com.aditya.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Member;

@Controller // annotation in spring that handles controlling part of a servlet...this is component already
public class HomeController {

    @ModelAttribute("course") // binds methode parameter vaules to the web view (ie. here in result.jsp file)
    public String courseName(){
        return "Java course";
    }

    @RequestMapping("/") // maps call to servlet
    public String home(){
        System.out.println("Home method called");
        return "index";
    }

//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
////        System.out.println("added");
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
////        System.out.println(result); // printed on console
//
//        session.setAttribute("result", result);
//
//        return "result.jsp";
//    }

//// another way using @RequestParam ...HttpServletRequest interface can be eliminated
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int x,@RequestParam("num2") int num2, HttpSession session){
//
//        int result = x + num2;
//
//        session.setAttribute("result", result);
//
//    return "result.jsp";
//    }

//// another way eliminating HttpSession interface... using Model class object
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int x, @RequestParam("num2") int num2, Model model){
//
//        int result = x + num2;
//
//        model.addAttribute("result", result);
//
//        return "result";
//    }

//  Model and View
//    @RequestMapping("add")
//    public ModelAndView add(@RequestParam("num1") int x, @RequestParam("num2") int num2, ModelAndView mv){
//
//        int result = x + num2;
//
//        mv.addObject("result", result);
//        mv.setViewName("result");
//
//        return mv;
//    }

//    @RequestMapping("addAlien")
//    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv){
//
//        System.out.println("Alien Added");
//
//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);
//
//        mv.addObject("alien", alien);
//        mv.setViewName("result");
//
//        return mv;
//    }

// a way by using model attribute using spring....elimination @RequestParam
//    @RequestMapping("addAlien")
//    public String addAlien(@ModelAttribute Alien alien){
//
//        System.out.println("Alien Added");
//
//        return "result";
//    }

    // without model attribute also -->> cause its optional
    @RequestMapping("addAlien")
    public String addAlien(Alien alien){

        System.out.println("Alien Added");

        return "result";
    }
}

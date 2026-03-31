package org.lessons.java_hello_spring_mvc.controllers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String welcome(@RequestParam(name = "name") String name, Model model) {

        model.addAttribute("name", name);

        return "index";
    }

    @GetMapping("/time")
    public String time(Model model) {

        model.addAttribute("time", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        return "time";
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int x, @RequestParam int y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("sum", x + y);
        return "sum";
    }

}


package com.r3negade.KursWork.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homepage( Model model){
        return "homepage";
    }
    @GetMapping("/client")
    public String client( Model model){
        return "client";
    }
    @GetMapping("/saledep")
    public String saledep( Model model){
        return "saledep";
    }
    @GetMapping("/developdep")
    public String developdep( Model model){
        return "developdep";
    }
    @GetMapping("/financedep")
    public String financedep( Model model){
        return "financedep";
    }
    @GetMapping("/buydep")
    public String buydep( Model model){
        return "buydep";
    }

}
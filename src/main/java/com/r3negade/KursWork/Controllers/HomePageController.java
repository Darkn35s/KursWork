
package com.r3negade.KursWork.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {
    @GetMapping("/")
    public String homepage( Model model){
        return "homepage";
    }
}
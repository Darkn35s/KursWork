package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.Entities.Materials;
import com.r3negade.KursWork.PostgresController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StorageController {
    @RequestMapping(value="/storage", method= RequestMethod.GET)
    public String storage(Model model) {
        List<Materials> items = PostgresController.GetINSTANSE().getMaterial();
        model.addAttribute("items", items);
        return "storage";
    }
}

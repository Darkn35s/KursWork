package com.r3negade.KursWork.Controllers;
import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.PostgresController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @RequestMapping(value="/client", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("client", new Client());
        List<Client> items = PostgresController.GetINSTANSE().getClients();
        model.addAttribute("items", items);
        return "client";
    }
    @RequestMapping(value = "/client",method = RequestMethod.POST)
    public String blogItemAdd(@ModelAttribute Client client, Model model){
        PostgresController.GetINSTANSE().addClient(client);
        return "redirect:/client";
    }


}

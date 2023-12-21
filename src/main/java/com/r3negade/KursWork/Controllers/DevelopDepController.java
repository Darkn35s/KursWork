package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.PostgresController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DevelopDepController {
    @RequestMapping(value="/developdep", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute(" ", new Client());
        List<Client> items = PostgresController.GetINSTANSE().getClients();
        model.addAttribute("items", items);
        return "developdep";
    }

}

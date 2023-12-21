package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.Entities.DevOrder;
import com.r3negade.KursWork.PostgresController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@Controller
public class DevelopDepController {
    @RequestMapping(value="/developdep", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("devorder", new DevOrder());
        model.addAttribute("items", PostgresController.GetINSTANSE().getDevOrder());
        return "developdep";
    }

    @RequestMapping(value="/developdep", method= RequestMethod.POST)
    public String addDevOrder(@ModelAttribute DevOrder order, Model model) {

        PostgresController.GetINSTANSE().addDevOrder(order);
        return "redirect:/developdep";
    }
    @RequestMapping(value="/developdep/{id}/notice", method= RequestMethod.GET)
    public String notice(@PathVariable(value = "id") int id, Model model) {
        PostgresController.GetINSTANSE().noticeDevOrder(id);
        return "redirect:/developdep";
    }

}

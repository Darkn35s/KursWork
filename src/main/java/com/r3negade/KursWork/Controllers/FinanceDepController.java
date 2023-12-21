package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.ProdOrder;
import com.r3negade.KursWork.PostgresController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
@Controller
public class FinanceDepController {
    @RequestMapping(value="/financedep", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("items", PostgresController.GetINSTANSE().getProdOrder());
        return "financedep";
    }
    @RequestMapping(value="/financedep/{id}/pay", method= RequestMethod.GET)
    public  String formEdit(@PathVariable(value = "id") long id, Model model){
        
        return "payform";
    }


}

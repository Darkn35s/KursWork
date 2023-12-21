package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.Entities.ProdOrder;
import com.r3negade.KursWork.PostgresController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BuyDepController {
    @RequestMapping(value="/buydep", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("prodorder", new ProdOrder());
        model.addAttribute("items", PostgresController.GetINSTANSE().getProdOrder());
        return "buydep";
    }
    @RequestMapping(value = "/buydep",method = RequestMethod.POST)
    public String blogItemAdd(@ModelAttribute ProdOrder prodOrder, Model model){
        prodOrder.setTotal(prodOrder.getMatAmount()*prodOrder.getMatCnt()/100*(prodOrder.getNdc()+100));
        PostgresController.GetINSTANSE().addProdOrder(prodOrder);
        return "redirect:/buydep";
    }
}

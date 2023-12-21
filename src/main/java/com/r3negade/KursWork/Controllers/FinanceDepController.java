package com.r3negade.KursWork.Controllers;

import com.r3negade.KursWork.Entities.Accounting;
import com.r3negade.KursWork.Entities.Client;
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
    @RequestMapping(value="/financedep/{id}/payform", method= RequestMethod.GET)
    public  String formEdit(@PathVariable(value = "id") int id, Model model){
        Accounting acc= new Accounting();
        ProdOrder pr= PostgresController.GetINSTANSE().getProdOrder(id).get(0);
        acc.setAmount(pr.getTotal());
        acc.setIdOrderProd(pr.getOrderId());
        model.addAttribute("account",  acc);
        return "payform";
    }
    @RequestMapping(value = "/financedep",method = RequestMethod.POST)
    public String blogItemAdd(@ModelAttribute Accounting acc, Model model){
        PostgresController.GetINSTANSE().addAccounting(acc);
        return "redirect:/financedep";
    }





}

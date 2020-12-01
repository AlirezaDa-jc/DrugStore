package ir.maktab.demo.controller;

import ir.maktab.demo.domain.Drug;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.services.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alireza.d.a
 */

@Controller
@RequestMapping("/drug")
public class DrugController {

    public final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping(value = "/add")
    public String createDrug() {
        return "add-drug";
    }


    @PostMapping("/add-drug")
    public String createDrug(HttpServletRequest req, ModelMap modelMap) {
        try {
            Drug drug = new Drug();
            drug.setName(req.getParameter("name"));
            drug.setCode(req.getParameter("code"));
            drug.setPrice(Long.parseLong(req.getParameter("price")));
            drug.setDescription(req.getParameter("description"));
            drug.setQuantity(Long.valueOf(req.getParameter("quantity")));
            drugService.saveOrUpdate(drug);
            modelMap.addAttribute("message", "Successfully Done!");
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return "add-drug";
    }


    @GetMapping("/all-drugs")
    public String showAll(Model model) {
        model.addAttribute("allDrugs", drugService.findAll());
        return "show-all-drugs";
    }

    @GetMapping("/edit-drug/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Drug drug = drugService.findDrugById(id);
        model.addAttribute("editDrug", drug);
        return "edit-drug";
    }

    @PostMapping("/edit-drug")
    public String editDug(@ModelAttribute Drug editDrug) {
        try {
            drugService.saveOrUpdate(editDrug);
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return "add-drug";
    }


    @GetMapping("/delete-drug/{id}")
    public String deleteDrug(@PathVariable("id") Long id){
        drugService.deleteById(id);
        return "add-drug";
//        return "show-all-drugs";
    }
}

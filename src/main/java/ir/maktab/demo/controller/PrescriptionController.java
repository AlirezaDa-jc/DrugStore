package ir.maktab.demo.controller;

import ir.maktab.demo.domain.Prescription;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.services.PatientService;
import ir.maktab.demo.services.PrescriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alireza.d.a
 */
@Controller
@RequestMapping("prescription")
public class PrescriptionController {
    public final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(value = "/add")
    public String createPrescription() {
        return "add-prescription";
    }


    @PostMapping("/add-prescription")
    public String createPrescription(HttpServletRequest req, ModelMap modelMap) {
        try {
            Prescription prescription = new Prescription();
            prescription.setPatient(PatientController.getTempPatient());
            prescription.setCode(req.getParameter("code"));
            prescription.setIssueDate(req.getParameter("issuedate"));
            prescription.setVisitDate(req.getParameter("visitdate"));
            modelMap.addAttribute("message", "Successfully Done!");
            prescriptionService.saveOrUpdate(prescription);
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return "add-prescription";
    }


    @GetMapping("/all-prescriptions")
    public String showAll(Model model) {
        model.addAttribute("allPrescriptions", prescriptionService.findAll());
        return "show-all-prescriptions";
    }



    @GetMapping("/delete-prescription/{id}")
    public String deletePrescription(@PathVariable("id") Long id){
        prescriptionService.deleteById(id);
        return "add-drug";
    }
}

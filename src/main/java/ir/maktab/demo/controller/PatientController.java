package ir.maktab.demo.controller;

import ir.maktab.demo.domain.Patient;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alireza.d.a
 */
@Controller
@RequestMapping("/patient")
public class PatientController {

    public final PatientService patientService;
    private static Patient tempPatient;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public static Patient getTempPatient() {
        return tempPatient;
    }

    @GetMapping("/add-patient")
    public String sendPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add-patient")
    public String savePatient(@ModelAttribute Patient patient, Model model) {
        try {
            patientService.saveOrUpdate(patient);
            tempPatient = patient;
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
//\
        return "successful-add-patient";
    }

    @GetMapping("/all-patients")
    public String showAllPatients(Model model) {
        model.addAttribute("allPatients", patientService.findAll());
        return "show-all-patients";
    }

    @GetMapping("/edit-patient/{id}")
    public String editPatient(@PathVariable("id") Long editId, Model model) {
        model.addAttribute("editPatient", patientService.findPatientById(editId));
        return "edit-patient";
    }

    @GetMapping("/detailed-patient/{id}")
    public String viewDetailedPatient(@PathVariable("id") Long patient, Model model) {
        model.addAttribute("detailedPatient", patientService.findPatientById(patient));
        return "show-detailed-patient";
    }

    @PostMapping("/edit-patient")
    public String editPatient(@ModelAttribute Patient patient) {
        try {
            patientService.saveOrUpdate(patient);
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return "add-drug";
    }
    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable("id") Long id){
        patientService.deleteById(id);
        return "add-drug";
    }

}

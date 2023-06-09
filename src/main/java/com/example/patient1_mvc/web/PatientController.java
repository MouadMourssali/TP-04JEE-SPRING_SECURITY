package com.example.patient1_mvc.web;

import com.example.patient1_mvc.entities.Patient;
import com.example.patient1_mvc.repositories.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/user/index")
    public String patients(Model model, @RequestParam(name="page",defaultValue = "0") int page, @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword){
        Page<Patient> l = patientRepository.findByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("ListPatients",l.getContent());
        model.addAttribute("Pages",new int[l.getTotalPages()]);
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

    @GetMapping(path = "/admin/delete")
    public String DeletePatient(Model model,Long id){
        patientRepository.deleteById(id);
        return "redirect:/user/index";
    }

    @GetMapping(path = "/admin/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }

    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name="page",defaultValue = "0") int page,@RequestParam(name="keyword",defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path = "/admin/edit")
    public String edit(Model model,Long id,String keyword,int page){
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient == null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editPatient";
    }

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/user/index";
    }




}

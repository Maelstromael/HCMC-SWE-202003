package com.hcmc.patient.controller;

import com.hcmc.patient.model.Patient;
import com.hcmc.patient.services.IPatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "/patient")
public class Patients {

    @Autowired
    IPatientServices patientServices;

    @GetMapping(value = "/list")
    public String retrieveAllPatients(Model model){
        List<Patient> list = this.patientServices.getAllPatients();

        model.addAttribute("patients" , list);

        return "patients";
    }

    @GetMapping(value = "/elderly")
    public String retrieveElderlyPatients(Model model){

        List<Patient> list = this.patientServices.getElderlyPatients();

        model.addAttribute("patients" , list);

        return "patients";
    }

}

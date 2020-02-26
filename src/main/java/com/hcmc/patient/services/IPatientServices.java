package com.hcmc.patient.services;

import com.hcmc.patient.model.Patient;

import java.util.List;

public interface IPatientServices {

    public List<Patient> getAllPatients();

    public List<Patient> getElderlyPatients();

    public Patient save(Patient patient);

}

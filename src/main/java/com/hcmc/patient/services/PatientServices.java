package com.hcmc.patient.services;

import com.hcmc.patient.dao.PatientRepository;
import com.hcmc.patient.model.Patient;
import com.hcmc.patient.util.PatientFullNameComparatorAsc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PatientServices implements IPatientServices {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> list = this.patientRepository.findAll();
        return list
                .stream()
                .sorted(new PatientFullNameComparatorAsc())
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> getElderlyPatients() {
        Calendar today = Calendar.getInstance();
        today.roll(Calendar.YEAR , -65);
        System.err.println(today.getTime());
        List<Patient> list = this.patientRepository.findAllElderly(today.getTime());
        return list
                .stream()
                .sorted(new PatientFullNameComparatorAsc())
                .collect(Collectors.toList());
    }

    @Override
    public Patient save(Patient patient) {
        return this.patientRepository.save(patient);
    }
}

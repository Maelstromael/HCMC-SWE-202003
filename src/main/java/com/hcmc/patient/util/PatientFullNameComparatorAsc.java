package com.hcmc.patient.util;

import com.hcmc.patient.model.Patient;

import java.util.Comparator;

public class PatientFullNameComparatorAsc implements Comparator<Patient> {

    public int compare(Patient a, Patient b)
    {
        return a.getFullNames().compareTo(b.getFullNames());
    }


}

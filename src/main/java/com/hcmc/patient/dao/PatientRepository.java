package com.hcmc.patient.dao;

import com.hcmc.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient , Long> {

    @Query("select p from Patient p where p.dateOfBirth <= :birthdate")
    public List<Patient> findAllElderly(@Param(value = "birthdate") Date birthdate);

}

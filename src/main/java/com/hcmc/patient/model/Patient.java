package com.hcmc.patient.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Getter
@Setter
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @NotNull
    private String patientNumber;

    @NotNull
    private boolean isAnOutPatient;

    @NotNull @NotEmpty
    private String fullNames;

    private String emailAddress;
    private String contactPhoneNumber;

    @NotNull @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;


    public Patient() {
    }

    public Patient(String patientNumber , boolean isAnOutPatient ,
                   String fullNames, String emailAddress,
                   String contactPhoneNumber, Date dateOfBirth) {

        this.patientNumber = patientNumber;
        this.isAnOutPatient = isAnOutPatient;
        this.fullNames = fullNames;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;

    }

}

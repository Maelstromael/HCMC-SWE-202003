package com.hcmc.patient.config;

import com.hcmc.patient.dao.PatientRepository;
import com.hcmc.patient.model.Patient;
import com.hcmc.patient.services.IPatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
    
    @Autowired
    private IPatientServices patientServices;

    @Override
    public void run(String... strings) throws Exception {
        String sDate1="1949-12-03";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);

        Patient p1 = new Patient("EP1000002",false ,"Ann-Marie Washington", "awashington@hcmc.org", "(641) 002-0034", date1);
        patientServices.save(p1);

        date1 = new SimpleDateFormat("yyyy-MM-dd").parse("1950-01-03");
        Patient p2 = new Patient("EP1000003",true ,"Diego A. Ortiz", "", "", date1);
        patientServices.save(p2);

        date1 = new SimpleDateFormat("yyyy-MM-dd").parse("1959-05-21");
        Patient p3 = new Patient("P1000001",true ,"John H. Smith", "jhsmith@globalmail.net", "(641) 001-0012", date1);
        patientServices.save(p3);

        date1 = new SimpleDateFormat("yyyy-MM-dd").parse("1945-03-18");
        Patient p4 = new Patient("EP1000004",false ,"Rebecca Jane Andrews", "", "(123) 001-1234", date1);
        patientServices.save(p4);

        date1 = new SimpleDateFormat("yyyy-MM-dd").parse("1954-11-07");
        Patient p5 = new Patient("P1000005",true ,"Richard \"Dooley\" K. Albertson", "richie.k.albertson@gmail.com", "", date1);
        patientServices.save(p5);

        System.out.println(" -- Database has been initialized");
    }

}

package com.ironhack.labjavaintrotojpawithspringdataes;

import com.ironhack.labjavaintrotojpawithspringdataes.model.Customer;
import com.ironhack.labjavaintrotojpawithspringdataes.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpawithspringdataes.model.Flight;
import com.ironhack.labjavaintrotojpawithspringdataes.model.FlightBooking;
import com.ironhack.labjavaintrotojpawithspringdataes.repository.CustomerRepository;
import com.ironhack.labjavaintrotojpawithspringdataes.repository.FlightBookingRepository;
import com.ironhack.labjavaintrotojpawithspringdataes.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabJavaIntroToJpaWithSpringDataEsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LabJavaIntroToJpaWithSpringDataEsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo, FlightRepository flightRepo, FlightBookingRepository bookingRepo) {
        return args -> {
            Customer agustineRiviera = customerRepo.save(new Customer(0, "Agustine Riviera", CustomerStatus.SILVER, 115235));
            Customer alainaSepulvida = customerRepo.save(new Customer(0, "Alaina Sepulvida", CustomerStatus.NONE, 6008));
            Customer tomJones = customerRepo.save(new Customer(0, "Tom Jones", CustomerStatus.GOLD, 205767));

            Flight flight1 = flightRepo.save(new Flight(0, "DL143", "Boeing 747", 400, 135));
            Flight flight2 = flightRepo.save(new Flight(0, "DL122", "Airbus A330", 236, 4370));
            Flight flight3 = flightRepo.save(new Flight(0, "DL53", "Boeing 777", 264, 2078));

            bookingRepo.save(new FlightBooking(0, agustineRiviera.getId(), flight1.getId()));
            bookingRepo.save(new FlightBooking(0, alainaSepulvida.getId(), flight2.getId()));
            bookingRepo.save(new FlightBooking(0, tomJones.getId(), flight3.getId()));
        };
    }
}

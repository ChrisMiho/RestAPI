package com.practice.RestAPI.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student chris = new Student(1L,
                    "Chris Mihovilovich",
                    "moose@gmail.com",
                    LocalDate.of(1994, Month.MAY, 13)
            );
            Student mike = new Student(
                    "Mike Mihovilovich",
                    "moose1@gmail.com",
                    LocalDate.of(1960, Month.JANUARY, 7)
            );
            repository.saveAll(
                    List.of(chris, mike)
            );
        };

    }
}

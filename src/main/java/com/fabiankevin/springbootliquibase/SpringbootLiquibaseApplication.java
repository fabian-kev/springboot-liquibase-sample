package com.fabiankevin.springbootliquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("students")
public class SpringbootLiquibaseApplication {

    @Autowired
    private PersonRepository personRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootLiquibaseApplication.class, args);
    }


    @GetMapping
    public List<Student> getAll(){
        return personRepository.findAll();
    }

    @PostMapping
    public Student create(@RequestBody StudentForm form){
        var student = Student.builder()
                .name(form.getName())
                .birthDate(LocalDate.now().minusDays(10000))
                .build();
        return personRepository.save(student);
    }


}

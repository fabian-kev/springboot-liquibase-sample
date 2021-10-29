package com.fabiankevin.springbootliquibase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Student, Long> {
}

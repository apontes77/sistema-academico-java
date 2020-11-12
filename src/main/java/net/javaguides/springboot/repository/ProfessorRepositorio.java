package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositorio extends JpaRepository <Professor, Integer> {
}

package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer> {
}

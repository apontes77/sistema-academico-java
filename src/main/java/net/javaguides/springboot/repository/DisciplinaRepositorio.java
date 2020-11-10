package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Integer> {
}

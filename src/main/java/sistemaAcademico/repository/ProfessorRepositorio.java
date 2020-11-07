package sistemaAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaAcademico.model.Professor;

@Repository
public interface ProfessorRepositorio extends JpaRepository <Professor, Integer> {
}

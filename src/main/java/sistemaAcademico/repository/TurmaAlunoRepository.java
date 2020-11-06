package sistemaAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistemaAcademico.model.TurmaAluno;
@Repository
public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno, Integer>{

}

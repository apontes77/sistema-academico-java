package sistemaAcademico.repository;


import sistemaAcademico.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepositorio extends JpaRepository<Turma, Integer> {
}

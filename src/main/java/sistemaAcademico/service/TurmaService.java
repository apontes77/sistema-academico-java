package sistemaAcademico.service;


import sistemaAcademico.model.Aluno;
import sistemaAcademico.model.Turma;
import sistemaAcademico.repository.TurmaRepositorio;
import sistemaAcademico.service.exceptions.DataIntegrityException;
import sistemaAcademico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurmaService {

    @Autowired
    private TurmaRepositorio turmaRepositorio;

    public Turma find(Integer id) {
        Optional<Turma> obj = turmaRepositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public Turma insert (Turma t){
        t.setId(null);
        return turmaRepositorio.save(t);

    }

    public Turma update (Turma t) {
       Turma newTurma = find(t.getId());
        updateData(newTurma, t);
        return turmaRepositorio.save(newTurma);

    }

    public void delete (Integer id) {
        try {
            turmaRepositorio.deleteById(id);
        }
        catch (DataIntegrityException e){
            throw new DataIntegrityException("não é possível excluir uma turma inexistente");
        }
    }

    public List<Turma> findAll() {
        return turmaRepositorio.findAll();
    }

    public void updateData(Turma newTurma, Turma t){
        newTurma.setNomeDaturma(t.getNomeDaturma());
    }
}

package sistemaAcademico.service;


import sistemaAcademico.model.Aluno;
import sistemaAcademico.repository.AlunoRepositorio;
import sistemaAcademico.service.exceptions.DataIntegrityException;
import sistemaAcademico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepositorio alunoRepositorio;

    public Aluno find(Integer id) {
        Optional<Aluno> obj = alunoRepositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public Aluno insert (Aluno a){
        a.setId(null);
        return alunoRepositorio.save(a);

    }

    public Aluno update (Aluno a) {
        Aluno newAluno = find(a.getId());
        updateData(newAluno, a);
        return alunoRepositorio.save(newAluno);

    }

    public void delete (Integer id) {
        try {
            alunoRepositorio.deleteById(id);
        }
        catch (DataIntegrityException e){
            throw new DataIntegrityException("não é possível excluir um aluno inexistente");
        }
    }

    public List<Aluno> findAll() {
        return alunoRepositorio.findAll();
    }

    public void updateData(Aluno newAluno, Aluno a){
        newAluno.setNome(a.getNome());
    }

}

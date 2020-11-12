package net.javaguides.springboot.resources;

import net.javaguides.springboot.model.Aluno;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.service.AlunoService;
import net.javaguides.springboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> find(@PathVariable Integer id) {
       Professor professor = professorService.find(id);
        return ResponseEntity.ok().body(professor);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Professor p) {

        Professor pr = professorService.insert(p);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pr.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update (@RequestBody Professor p, @PathVariable Integer id) {
        p.setId(id);
        p = professorService.update(p);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> list = professorService.findAll();
        list.stream()
                .map(obj -> new Professor())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}

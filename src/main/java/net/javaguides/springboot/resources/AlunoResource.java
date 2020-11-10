package net.javaguides.springboot.resources;


import net.javaguides.springboot.model.Aluno;
import net.javaguides.springboot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Aluno> find(@PathVariable Integer id) {
            Aluno aluno = alunoService.find(id);
            return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Aluno a) {

        Aluno al = alunoService.insert(a);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(al.getIdaluno())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update (@RequestBody Aluno a, @PathVariable Integer id) {
        a.setIdaluno(id);
        a = alunoService.update(a);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> list = alunoService.findAll();
         list.stream()
                .map(obj -> new Aluno())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

}

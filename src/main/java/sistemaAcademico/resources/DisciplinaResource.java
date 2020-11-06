package sistemaAcademico.resources;

import sistemaAcademico.model.Disciplina;
import sistemaAcademico.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Disciplina d) {

        Disciplina disciplina  = disciplinaService.insert(d);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(disciplina.getIddisciplina())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Disciplina> find(@PathVariable Integer id) {
        Disciplina disciplina = disciplinaService.find(id);
        return ResponseEntity.ok().body(disciplina);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Disciplina>> findAll() {
        List<Disciplina> list = disciplinaService.findAll();
        list.stream()
                .map(obj -> new Disciplina())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}

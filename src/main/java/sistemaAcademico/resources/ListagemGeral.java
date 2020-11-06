package sistemaAcademico.resources;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sistemaAcademico.model.Aluno;

@Controller
public class ListagemGeral {
	
	@GetMapping("/Users")
	public String relatorioFrequencia (Model model) {
		model.addAttribute("alunos", getAlunos());
	
		return "/Users.html";
	}
	
	public List<Aluno> getAlunos () {
		AlunoResource ar = new AlunoResource();
		
		return ar.findAll().getBody();
		
	}

}

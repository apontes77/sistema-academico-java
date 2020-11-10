package net.javaguides.springboot.resources;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.model.Aluno;

@Controller
public class ListagemGeral {
	
	@GetMapping("/usuarios")
	public String relatorioFrequencia (Model model) {
		model.addAttribute("alunos", getAlunos());
	
		return "/Users.html";
	}
	
	public List<Aluno> getAlunos () {
		AlunoResource ar = new AlunoResource();
		
		return ar.findAll().getBody();
		
	}

}

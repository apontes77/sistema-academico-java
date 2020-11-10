package net.javaguides.springboot.web;


import net.javaguides.springboot.model.Aluno;
import net.javaguides.springboot.repository.AlunoRepositorio;
import net.javaguides.springboot.service.AlunoService;
import net.javaguides.springboot.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;

import net.javaguides.springboot.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

import java.util.List;

@Controller
public class MainController {
	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/users")
	public String users(Model model) {
		AlunoService service = new AlunoService();

		List<Aluno> alunos = alunoRepositorio.findAll();

		model.addAttribute("students", alunos);
		return "Users";
	}

	@GetMapping("/report")
	public String generateReport() throws FileNotFoundException, JRException {
		ReportService r = new ReportService();
		return r.exportReport("html");
	}
}

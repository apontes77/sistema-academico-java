package sistemaAcademico.web;


import sistemaAcademico.model.Aluno;
import sistemaAcademico.repository.AlunoRepositorio;
import sistemaAcademico.service.AlunoService;
import sistemaAcademico.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

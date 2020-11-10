package net.javaguides.springboot.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioFrequencia {
	
	@GetMapping("/reportAttendance")
	public String relatorioFrequencia (Model model) {
		AlunoResource ar = new AlunoResource();
		
		model.addAttribute("reports", ar.findAll());
		return "/reportAttendance";
	}
}

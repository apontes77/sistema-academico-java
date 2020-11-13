package net.javaguides.springboot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrationLoginSpringBootSecurityThymeleafApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepositorio alunoRepository;

	@Autowired
	private CursoRepositorio cursoRepository;

	@Autowired
	private DisciplinaRepositorio disciplinaRepository;

	@Autowired
	private TurmaRepositorio turmaRepository;

	@Autowired
	private TurmaAlunoRepository turmaAlunoRepository;

	@Autowired
	private ProfessorRepositorio professorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		Curso c = new Curso(null, "ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");

		Disciplina d = new Disciplina(null, "COMPILADORES");
		Disciplina d1 = new Disciplina(null, "DESENVOLVIMENTO WEB");
		c.setDisciplinas(Arrays.asList(d, d1));

		Aluno a1 = new Aluno(null, "Joe Biden", sdf.parse("09-07-1945"), sdf.parse("10-02-2019"), "biden@mail.com",
				31231123);
		Aluno a2 = new Aluno(null, "Donald Trump", sdf.parse("23-12-1987"), sdf.parse("13-02-2019"), "trump@mail.com",
				1312312);
		Aluno a3 = new Aluno(null, "Barack Obama", sdf.parse("03-12-1987"), sdf.parse("10-02-2019"), "obama@mail.com",
				1312313);
		Aluno a4 = new Aluno(null, "Denzel Washington", sdf.parse("11-12-1987"), sdf.parse("11-02-2019"), "denzel@mail.com",
				1312314);
		Aluno a5 = new Aluno(null, "Martin Lawrence", sdf.parse("18-12-1987"), sdf.parse("12-02-2019"), "martin@mail.com",
				1312315);
		Aluno a6 = new Aluno(null, "Steffanny Gritzinkel", sdf.parse("21-12-1987"), sdf.parse("16-02-2019"), "gritz@mail.com",
				1312316);
		Aluno a7 = new Aluno(null, "Michael Jordan", sdf.parse("01-12-1987"), sdf.parse("01-02-2019"), "jordan@mail.com",
				1312317);

		Turma turma01 = new Turma(null, d, "C01");
		Turma turma02 = new Turma(null, d1, "C02");

		Set<Turma> turmas = new HashSet<>();
		turmas.add(turma01);
		turmas.add(turma02);

		cursoRepository.save(c);
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7));
		disciplinaRepository.save(d);



		Professor p1 = new Professor(null, "Von Neumann");
		p1.setTurmas(turmas);
		professorRepositorio.save(p1);
		turma01.setProfessor(p1);
		turma02.setProfessor(p1);
		turmaRepository.save(turma01);
		turmaRepository.save(turma02);

		TurmaAluno turmaAluno01 = new TurmaAluno(a1.getIdaluno(), turma01.getId(), 9.5, 10.0, 10);
		TurmaAluno turmaAluno02 = new TurmaAluno(a2.getIdaluno(), turma01.getId(), 6.5, 8.5, 5);
		TurmaAluno turmaAluno03 = new TurmaAluno(a3.getIdaluno(), turma01.getId(), 6.5, 8.5, 5);
		TurmaAluno turmaAluno04 = new TurmaAluno(a4.getIdaluno(), turma02.getId(), 6.5, 8.5, 5);
		TurmaAluno turmaAluno05 = new TurmaAluno(a5.getIdaluno(), turma02.getId(), 6.5, 8.5, 5);
		TurmaAluno turmaAluno06 = new TurmaAluno(a6.getIdaluno(), turma02.getId(), 6.5, 8.5, 95);
		TurmaAluno turmaAluno07 = new TurmaAluno(a7.getIdaluno(), turma02.getId(), 6.5, 8.5, 100);

		turmaAlunoRepository.saveAll(Arrays.asList(turmaAluno01, turmaAluno02, turmaAluno03, turmaAluno04, turmaAluno05, turmaAluno06, turmaAluno07));



	}

}
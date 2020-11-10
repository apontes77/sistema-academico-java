package net.javaguides.springboot;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.validations.CalcularAprovacao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RegistrationLoginSpringBootSecurityThymeleafApplicationTests {

	@BeforeTestClass
	public static void setUpClass() throws Exception {

	}

	@AfterAll
	public static void tearDownClass() throws Exception {

	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testFrequenciaMenor90() throws ParseException {
		// frequencia < 90

		CalcularAprovacao ca = new CalcularAprovacao();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		Curso c = new Curso(null, "ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");

		Disciplina d = new Disciplina(null, "COMPILADORES");
		Disciplina d1 = new Disciplina(null, "DESENVOLVIMENTO WEB");
		c.setDisciplinas(Arrays.asList(d, d1));

		Aluno a1 = new Aluno(null, "Joe Biden", sdf.parse("09-07-1945"), sdf.parse("10-02-2019"), "biden@mail.com",
				31231123);

		Turma turma01 = new Turma(null, d, "C01");


		TurmaAluno turmaAluno01 = new TurmaAluno(a1.getIdaluno(), turma01.getId(), 9.5, 10.0, 10);

		boolean expResult = true;

		boolean result = ca.calcAprovacao(turmaAluno01.getNota1(), turmaAluno01.getNota2(), turmaAluno01.getFrequencia());

		// método assertEquals ou ainda "espera que seja igual" compara dois valores do mesmo tipo
		assertEquals(expResult, true);
	}

	@Test
	public void testNullNotes () throws ParseException {
		CalcularAprovacao ca = new CalcularAprovacao();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		Curso c = new Curso(null, "ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");

		Disciplina d = new Disciplina(null, "COMPILADORES");
		Disciplina d1 = new Disciplina(null, "DESENVOLVIMENTO WEB");
		c.setDisciplinas(Arrays.asList(d, d1));

		Aluno a1 = new Aluno(null, "Joe Biden", sdf.parse("09-07-1945"), sdf.parse("10-02-2019"), "biden@mail.com",
				31231123);

		Turma turma01 = new Turma(null, d, "C01");


		TurmaAluno turmaAluno01 = new TurmaAluno(a1.getIdaluno(), turma01.getId(), -9.0, -8.0, 10);

		boolean expectedNullNotes = true;

		boolean result = ca.verificaSeNotaEhInvalida(turmaAluno01.getNota1(), turmaAluno01.getNota2());

		assertEquals(expectedNullNotes, result);
	}


}

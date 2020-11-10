package sistemaAcademico.service.Test;

import net.javaguides.springboot.model.Aluno;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoServiceTest {

    @BeforeEach
    void setUp(Aluno a) {
        Assertions.assertNotNull(a);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void find() {
        Assertions.assertTrue(true);
    }

    @Test
    void insert(Aluno a) {
        a = new Aluno();
        Assertions.assertNotNull(a);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateData() {
    }
}
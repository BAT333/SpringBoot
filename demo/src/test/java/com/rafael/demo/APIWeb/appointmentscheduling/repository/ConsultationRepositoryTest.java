package com.rafael.demo.APIWeb.appointmentscheduling.repository;

import com.rafael.demo.APIWeb.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ConsultationRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TestEntityManager em;
    @Test
    @DisplayName("AQUI SERVE PARA DESCREVE PARA QUE SERVE METODO ")
    void findByDoctorAndConsultationDateBetween() {
       var user = repository.findByLogin("rafael.alves.@vaz");
        assertThat(user).isNull();

    }
}
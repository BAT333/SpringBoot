package com.rafael.demo.APIWeb.Doctor.Controller;

import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.model.ListDoctor;
import com.rafael.demo.APIWeb.Doctor.model.Specialty;
import com.rafael.demo.APIWeb.Doctor.service.ServiceDoutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DoctorControllerTest {
@Autowired
private MockMvc mvc;
@Autowired
private JacksonTester<DataDoctor> dataDoctorjsonTest;
@Autowired
private JacksonTester<ListDoctor> listDoctorjsontest;
@MockBean
private ServiceDoutor doutor;

    @Test
    @DisplayName("ERRO SE NÃO ENCONTRA")
    @WithMockUser
    void exclusion() throws Exception {
        var response =  mvc.perform(delete("/Doctor/exclusion/7"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
    @Test
    @DisplayName("ERRO SE NÃO ENCONTRA")
    @WithMockUser
    void agenda() throws Exception {
      //  when(doutor.register(any())).thenReturn(new ListDoctor(1L,"Dsd","eqwe","adfa",Specialty.CARDIOLOGY));
       // when(doutor.register(any())).thenReturn(null);

        var response =  mvc.perform(post("/Doctor/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dataDoctorjsonTest.write(
                                new DataDoctor("fsf","adfa","afa","sada", Specialty.CARDIOLOGY,null)
                        ).getJson())
                ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        var json = listDoctorjsontest.write(new ListDoctor(1L,"Dsd","eqwe","adfa",Specialty.CARDIOLOGY));
        assertThat(response.getContentAsString()).isEqualTo(json);
    }
}
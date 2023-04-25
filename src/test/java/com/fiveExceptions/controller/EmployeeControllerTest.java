package com.fiveExceptions.controller;

import com.fiveExceptions.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeController.class)
@WithMockUser
@AutoConfigureMockMvc
class EmployeeControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeService employeeService;
//
//    @Test
//    public void getEmployeeById() throws Exception {
//        Mockito.when().then();
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}").accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        System.out.println("result" + result);
//    }
}
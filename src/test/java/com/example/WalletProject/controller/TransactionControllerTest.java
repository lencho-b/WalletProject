package com.example.WalletProject.controller;

import com.example.WalletProject.controllers.TransactionController;
import com.example.WalletProject.models.DTO.transaction.TransactionDto;
import com.example.WalletProject.models.DTO.transaction.TransactionRequestDto;
import com.example.WalletProject.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;


    @WithMockUser(value = "spring")
    @Test
    public void getAllTransactionByAccountId() throws Exception {
        mockMvc.perform(get("/1/transaction").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    public void getOneTransactionById() throws Exception {
        mockMvc.perform(get("/1/transaction/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    public void saveNewTransaction() throws Exception {
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setAccountIdTo(1L);
        transactionRequestDto.setValue(BigDecimal.ONE);
        transactionRequestDto.setTypeName(" ");
        transactionRequestDto.setMessage(" ");

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/1/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionRequestDto)))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    public void getAllTransactionTypes() throws Exception {
        mockMvc.perform(get("/1/transaction-type").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}

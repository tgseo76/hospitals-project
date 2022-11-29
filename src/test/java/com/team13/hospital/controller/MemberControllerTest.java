package com.team13.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team13.hospital.domain.dto.MemberRequest;
import com.team13.hospital.domain.dto.MemberResponse;
import com.team13.hospital.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberService memberService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void create() throws Exception {
        MemberRequest memberRequest = MemberRequest.builder()
                .name("홍길동")
                .address("서울")
                .phone("01011112222")
                .age(25)
                .build();

        MemberResponse memberResponse = MemberResponse.builder()
                .id(1L)
                .admin(false)
                .name("홍길동")
                .age(25)
                .build();

        when(memberService.create(any(MemberRequest.class))).thenReturn(memberResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(memberRequest))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.admin").value(false))
                .andExpect(jsonPath("$.name").value("홍길동"))
                .andExpect(jsonPath("$.age").value(25))
                .andDo(print());

        verify(memberService).create(any(MemberRequest.class));
    }
}
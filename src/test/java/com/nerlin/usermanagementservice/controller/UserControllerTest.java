package com.nerlin.usermanagementservice.controller;

import com.nerlin.usermanagementservice.service.UserService;
import com.nerlin.usermanagementservice.model.Role;
import com.nerlin.usermanagementservice.model.User;
import com.nerlin.usermanagementservice.dto.UserLoginDto;
import com.nerlin.usermanagementservice.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtil jwtUtil;  // Mock del bean JwtUtil

    private User user;
    private UserLoginDto userLoginDto;

    @BeforeEach
    void setUp() {
        // Creazione del ruolo
        Role role = new Role(1L, "ROLE_USER");

        // Creazione dell'utente con il ruolo
        user = new User();
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setRoles(List.of(role));  

        // Creazione di UserLoginDto per il test di login
        userLoginDto = new UserLoginDto();
        userLoginDto.setUsername("testuser");
        userLoginDto.setPassword("password123");
    }

    @Test
    @WithMockUser
    void testRegisterUser() throws Exception {
        Mockito.when(userService.registerUser(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testLoginUser() throws Exception {
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userLoginDto))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

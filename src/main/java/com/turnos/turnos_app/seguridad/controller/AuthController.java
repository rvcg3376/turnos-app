package com.turnos.turnos_app.seguridad.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnos.turnos_app.seguridad.model.Usuario;
import com.turnos.turnos_app.seguridad.service.AuthService;
import com.turnos.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        Usuario user = authService.login(username, password);

        String token = jwtUtil.generarToken(user.getUsername(), user.getRol());

        return Map.of(
                "token", token,
                "rol", user.getRol()
        );
    }
}
package com.rafael.demo.APIWeb.user.contorller;

import com.rafael.demo.APIWeb.infra.token.TokenService;
import com.rafael.demo.APIWeb.infra.token.model.DadosToken;
import com.rafael.demo.APIWeb.user.User;
import com.rafael.demo.APIWeb.user.model.DataUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;


    @PostMapping
    @Transactional
    public ResponseEntity Login(@RequestBody @Valid DataUser user){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.login(),user.password());
        var authe = manager.authenticate(token);
        String tokenJWT = tokenService.geradorToken((User)authe.getPrincipal());
        return ResponseEntity.ok(new DadosToken(tokenJWT));
    }

}

package com.prashant.controller;

import com.prashant.dto.LoginJWTResponse;
import com.prashant.entity.LoginRequest;
import com.prashant.entity.User;
import com.prashant.service.UserServiceImpl;
import com.prashant.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationProvider authenticationManager;



    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginJWTResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        String token = null;
        Set<String> roles = new HashSet<>();
        Map<String, Object> claims = new HashMap<>();

        authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        for (GrantedAuthority r: userDetails.getAuthorities()){
            roles.add(r.getAuthority());
        }
        claims.put("Roles", roles);
        token =jwtUtils.generateToken(claims,loginRequest.getUsername());
         if (token != null)
             return new ResponseEntity<>(new LoginJWTResponse(token,  "token genrated successfully.."), HttpStatus.OK);
         else
             throw  new IllegalAccessException("Invalid username/password");
    }


    @GetMapping("/getAll")
    public List<User> getUsers(){
        return userService.getAll();
    }
}

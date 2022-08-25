package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;
import com.example.readerlibrary.DTO.DTO;
import com.example.readerlibrary.Model.AppAdmin;
import com.example.readerlibrary.Model.Reader;
import com.example.readerlibrary.Model.User;
import com.example.readerlibrary.Repository.AppAdminRepository;
import com.example.readerlibrary.Repository.AuthRepository;
import com.example.readerlibrary.Repository.ReaderRepository;
//import com.example.readerlibrary.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
//    private  final AuthService authService;
    private final AuthRepository authRepository;
    private final ReaderRepository readerRepository;
    private final AppAdminRepository appAdminRepository;


    @GetMapping("/user")
    public ResponseEntity welcomeUser() {
        return ResponseEntity.status(200).body("Welcome User");
    }

    @GetMapping("/admin")
    public ResponseEntity welcomeAdmin() {
        return ResponseEntity.status(200).body("Welcome Admin");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DTO dto){
        String hashedPassword=new BCryptPasswordEncoder().encode(dto.getPassword());
        dto.setPassword(hashedPassword);
        User user=new User(null,dto.getUsername(),dto.getPassword(),dto.getRole());
        User newUser=authRepository.save(user);
        if(dto.getRole().equals("ADMIN")){
            AppAdmin appAdmin=new AppAdmin(null,dto.getAdminName(),newUser.getId());
            appAdminRepository.save(appAdmin);
        }else {
            Reader reader=new Reader(null,dto.getReaderName(),newUser.getId());
            readerRepository.save(reader);
        }


        return ResponseEntity.status(201).body("New User registered !");
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new Api("Welcome back !",200));
    }
}



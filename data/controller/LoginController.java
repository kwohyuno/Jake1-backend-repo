package data.controller;

import data.dto.BoardDto;
import data.dto.UserDto;
import data.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import data.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class LoginController {


    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session){
        return new ResponseEntity<>(loginService.login(dto,session), HttpStatus.OK);
    }
}

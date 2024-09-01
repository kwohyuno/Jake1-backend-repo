package data.controller;


import data.dto.UserDto;
import data.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import data.service.SignupService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api")
@Slf4j
public class SignupController {

    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    SignupService signupService;


    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto dto, HttpSession session){
        logger.info("SignupController: signup");
        logger.info("SignupController: "+dto.toString());
        log.info(dto.toString());
        return new ResponseEntity<UserDto>(signupService.signup(dto, session), HttpStatus.OK);
    }

}


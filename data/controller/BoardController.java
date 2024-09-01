package data.controller;


import data.dto.BoardDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import data.service.BoardService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BoardController {


    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public List<BoardDto> getBoard(){
        return boardService.getAllBoards();
    }

    @PostMapping("/board")
    public ResponseEntity<BoardDto> insertBoard(@RequestBody BoardDto dto, HttpSession session){
        return new ResponseEntity<BoardDto>(boardService.insertBoard(dto, session), HttpStatus.OK);
    }



}


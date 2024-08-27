package data.controller;


import data.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



}

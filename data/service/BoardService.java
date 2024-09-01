package data.service;

import data.dto.BoardDto;
import data.entity.BoardEntity;
import data.repository.BoardRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class BoardService {

    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired(required=true)
    private BoardRepository boardRepository;

    public List<BoardDto> getAllBoards() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        return boardEntities.stream()
                .map(boardEntity -> BoardDto.builder()
                        .id(boardEntity.getId())
                        .userId(boardEntity.getUserid())
                        .title(boardEntity.getTitle())
                        .content(boardEntity.getContent())
                        .createdAt(boardEntity.getCreatedat())
                        .updatedAt(boardEntity.getUpdatedat())
                        .build())
                .toList();
    }

    public BoardDto insertBoard(BoardDto dto, HttpSession session) {
        try{
            BoardEntity board = BoardEntity.toEntity(dto);
            boardRepository.save(board);
            return dto;
        }catch(Exception e) {
            logger.error("insert Board Error", e);
            throw e;
        }
    }
}

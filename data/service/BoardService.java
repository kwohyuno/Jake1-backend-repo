package data.service;

import data.dto.BoardDto;
import data.entity.BoardEntity;
import data.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardDto> getAllBoards() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        return boardEntities.stream()
                .map(boardEntity -> BoardDto.builder()
                        .id(boardEntity.getId())
                        .user_id(boardEntity.getUserid())
                        .title(boardEntity.getTitle())
                        .content(boardEntity.getContent())
                        .created_at(boardEntity.getCreatedat())
                        .updated_at(boardEntity.getUpdatedat())
                        .build())
                .toList();
    }
}

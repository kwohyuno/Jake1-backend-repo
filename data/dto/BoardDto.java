package data.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import data.entity.BoardEntity;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private int id;
    private int user_id;
    private String title;
    private String content;
    private Timestamp created_at;
    private Timestamp updated_at;

    public static BoardDto toBoardDto(BoardEntity entity){
        return BoardDto.builder()
                .id(entity.getId())
                .user_id(entity.getUserid())
                .title(entity.getTitle())
                .content(entity.getContent())
                .created_at(entity.getCreatedat())
                .updated_at(entity.getUpdatedat())
                .build();
    }
}
